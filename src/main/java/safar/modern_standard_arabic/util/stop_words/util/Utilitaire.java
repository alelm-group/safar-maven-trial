package safar.modern_standard_arabic.util.stop_words.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;
import safar.modern_standard_arabic.util.stop_words.model.StopWords;
import safar.modern_standard_arabic.util.stop_words.model.StopWord;


/**The <tt>Utiliaire</tt>class containing xml parser.
*
* @author BOUZOUBAA Karim
* @author NAMLY Driss
*/
public abstract class Utilitaire {

    /*** StopWords XML parser.
     * @param fileName a Strings containing the file Name
     * @return sws
     */

    public static StopWords parseXMLSW(final String fileName) {
        StopWords stopWords = null;
        try {
            System.out.print("lexicon reading...");
            Digester digester = new Digester();
            digester.setValidating(false);
            /*
            *start load
            */
            digester.addObjectCreate("stopWords", StopWords.class);
            digester.addObjectCreate("stopWords/stopWord", StopWord.class);
            digester.addBeanPropertySetter("stopWords/stopWord/vowForm",
                    "voweledform");
            digester.addBeanPropertySetter("stopWords/stopWord/vowForm",
                    "unvoweledform");
            digester.addBeanPropertySetter("stopWords/stopWord/prefix",
                    "pref");
            digester.addBeanPropertySetter("stopWords/stopWord/simpleStopWord",
                    "simpleSW");
            digester.addBeanPropertySetter("stopWords/stopWord/suffix",
                    "suff");
            digester.addSetNext("stopWords/stopWord", "addStopWord");

            /* end load sw */

            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(fileName);
            stopWords = (StopWords) digester.parse(is);

            System.out.println("done");
            System.out.println("Processing...");
        } catch (IOException | SAXException exc) {
        }
        return stopWords;
    }
    /*** diactritics Remover.
     * @param voweled a voweled String
     * @return unvoweled String
     */
    public static String strDiactriticsRemover(final String voweled) {
        return voweled.replaceAll("[ًٌٍَُِّْ]", "");
    }
    /*** diactritics Remover.
     * @param voweled a voweled String
     * @return unvoweled String
     */
    public static List<String> listDiactriticsRemover(final List<String>
            voweled) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < voweled.size(); i++) {
            lst.add(voweled.get(i).replaceAll("[ًٌٍَُِّْ]", ""));
        }
        return lst;
    }
   
    /**
     * get <tt>filesList</tt> of a specific directory.
     *
     * @param folderPath the folder path
     * @return a <tt>list String</tt> containing nouns particles simpleList
     */
    public static List<String> filesList(final String folderPath) {
        List<String> lstFiles = new ArrayList<>();
        File[] files = new File(folderPath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                lstFiles.add(file.getName());
            }
        }
        Collections.sort(lstFiles);
        return lstFiles;
    }

    /**
     * process <tt>cosine Similarity</tt> of two vectors.
     *
     * @param vectorA first vector
     * @param vectorB second vector
     * @return the <tt> cosine similarity</tt> value
     */
    public static double cosineSimilarity(final int[] vectorA,
            final int[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }


    /**
     * get <tt> Model List</tt> .
     *
     * @param listM the unsorted model list
     * @param vRBSWs the voweled rule based list
     * @return the <tt> final list </tt> of the model
     */
    public static List<String> getModelList(final List<String> listM,
            final List<String> vRBSWs) {
        List<String> uRBSWs =  listDiactriticsRemover(vRBSWs);
        String[][] dDPXs = new String[listM.size()][2];
        String[][] dDSWs;
        List<String> theList = new ArrayList<>();
        for (int i = 0; i < listM.size(); i++) {
            String[] parts = listM.get(i).split("\\|");
            dDPXs[i][0] = parts[1];
            dDPXs[i][1] = parts[0];
        }
        Arrays.sort(dDPXs, (final String[] entry1, final String[] entry2) -> {
            final String time1 = entry1[0];
            final String time2 = entry2[0];
            return time1.compareTo(time2);
        });
        int from = 0; int cpt = 0; int cptRBSW = 0; int limit = vRBSWs.size()/3;
        while (cpt < dDPXs.length && cptRBSW < limit) { //from == 0
//            System.out.println(dDPXs[cpt][1]);
            if (vRBSWs.contains(dDPXs[cpt][1])
                    || uRBSWs.contains(dDPXs[cpt][1])) {
                from = cpt;
                cptRBSW ++;
            }
            cpt++;
        }
//        System.out.println("==========");
        int p = 0;
        dDSWs = Arrays.copyOfRange(dDPXs, from, dDPXs.length);
        for (String[] dDSW : dDSWs) {
            if (!uRBSWs.contains(dDSW[1])) {
                theList.add(dDSW[1]);
            }
        }
        return theList;
    }

}
