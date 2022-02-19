 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.impl;

import common.constants.Constants;
import common.constants.Encoding;
import common.constants.Language;
import common.manage_errors.Errors;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import safar.modern_standard_arabic.basic.morphology.stemmer.interfaces
        .IStemmer;
import safar.modern_standard_arabic.basic.morphology.stemmer.model
        .StemmerAnalysis;
import safar.modern_standard_arabic.basic.morphology.stemmer.model
        .WordStemmerAnalysis;
import safar.modern_standard_arabic.basic.morphology.stemmer.util.Utilities;

/**
 * The <tt>Light10Stemmer</tt> class is an implementation of
 * <tt>IStemmer</tt> interface.
 * <br>It concerns Light10 stemmer implementation.
 * <br>To get an instance of this class, it's better to go through
 * <tt>StemmerFactory</tt> class instead of instantiating it directly.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @version 1.0
 * @see IStemmer
 * @see safar.modern_standard_arabic.basic.morphology.stemmer.factory.StemmerFactory
 */
public class Light10Stemmer implements IStemmer {

    /** to store start time and end time. */
    public static double startTime, endTime;
    /** to store time of execution. */
    public static double timeExecution;

    /**
     * Stems the <tt>String</tt> given in parameter and returns a <tt>List</tt>
     * of <tt>WordMorphologyAnalysis</tt> as result.
     * <br>Uses Light10 stemmer.
     *
     * @param text text to be stemmed
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    @Override
    public final List<WordStemmerAnalysis> stem(final String text) {
        List<WordStemmerAnalysis> result = new ArrayList<WordStemmerAnalysis>();

        startTime = System.currentTimeMillis();

        // remove diacritics and kashida ًٌٍَُِّْـ
        String text1 = text.replaceAll(
                "([\u064B\u064C\u064D\u064E\u064F\u0650\u0651\u0652\u0640])",
                "");
        //split on letters
        String[] splits;
        splits = text1.split("[\\s،\"\'.؟*!\\(\\)\\[\\]{},\\/#$^%&-+;"
                + "=_~|?]+");

        endTime = System.currentTimeMillis();
        timeExecution += endTime - startTime;         

        for (String item : splits) {

            startTime = System.currentTimeMillis();

            //remove all non-letters (diacritics, punctuation)
            String normalized1 = item.replaceAll("[^a-zA-Z0-9\u0621\u0622\u0623"
                    + "\u0624\u0625\u0626\u0627\u0628\u0629\u062A\u062B\u062C"
                    + "\u062D\u062E\u062F\u0630\u0631\u0632\u0633\u0634\u0635"
                    + "\u0636\u0637\u0638\u0639\u063A\u0641\u0642\u0643\u0644"
                    + "\u0645\u0646\u0647\u0648\u064A\u0649]", "");
            //normalize ya and Alef Maqsoura : s/ى/ي/g
            String normalized2 = normalized1.replaceAll("\u0649", "\u064A");
            // normalizing different alef-maad, alef-hamza-top,
            // alef-hamza-bottom, bare-alef
            // you can choose between light and aggressive normalization.
            // The default is aggressive light normalization
            // light normalization :
            // String normalized3 = normalized2.replaceAll(
            // "[\u0622\u0623\u0625]", "\u0627");
            // aggressive normalization s/[ءآأؤإئ]/ا/g
            String normalized3 = normalized2.replaceAll("[\u0621\u0622\u0623"
                    + "\u0624\u0625\u0626]", "\u0627");
            Pattern pattern = Pattern.compile("^(\u0648\u0627\u0644"
                    + "|\u0641\u0627\u0644|\u0628\u0627\u0644|\u0628\u062A"
                    + "|\u064A\u062A|\u0644\u062A|\u0645\u062A|\u062A\u062A"
                    + "|\u0648\u062A|\u0633\u062A|\u0646\u062A|\u0628\u0645"
                    + "|\u0644\u0645|\u0648\u0645|\u0643\u0645|\u0641\u0645"
                    + "|\u0627\u0644|\u0644\u0644|\u0648\u064A|\u0644\u064A"
                    + "|\u0633\u064A|\u0641\u064A|\u0648\u0627|\u0641\u0627"
                    + "|\u0644\u0627|\u0628\u0627|)"
                    + "(.+?)"
                    + "(\u0627\u062A|\u0648\u0627|\u062A\u0627|\u0648\u0646|"
                    + "\u0648\u0647|\u0627\u0646|\u062A\u064A|\u062A\u0647|"
                    + "\u062A\u0645|\u0643\u0645|\u0647\u0646|\u0647\u0645|"
                    + "\u0647\u0627|\u064A\u0629|\u062A\u0643|\u0646\u0627|"
                    + "\u064A\u0646|\u064A\u0647|\u0629|\u0647|\u064A|"
                    + "\u0627|)$");
            Matcher m = pattern.matcher(normalized3);
            String stem = "";
            String type = "";
            if (m.find()) {
                stem  = m.group(2);
                type = Constants.TYPE_STEM;
            }

            endTime = System.currentTimeMillis();
            timeExecution += endTime - startTime;

            // If necessary, add  && !(item == null)
            if (!item.trim().equals("")) {
            WordStemmerAnalysis wordStemmerAnalysis = new WordStemmerAnalysis();
            wordStemmerAnalysis.setWord(item);
            List<StemmerAnalysis> listStemmerAnalysis;
            listStemmerAnalysis = new ArrayList<StemmerAnalysis>();
            listStemmerAnalysis.add(new StemmerAnalysis(type, stem));
            wordStemmerAnalysis.setListStemmerAnalysis(listStemmerAnalysis);
            result.add(wordStemmerAnalysis);
            }
        }
        return result;
    }

    /**
     * Stems the content of the <tt>File</tt> given in parameter and returns a
     * <tt>List</tt> of <tt>WordStemmerAnalysis</tt> as result.
     * <br>The default encoding used for the input <tt>File</tt> is UTF-8.
     * <br>Uses Light10 stemmer.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    @Override
    public final List<WordStemmerAnalysis> stem(final File inputFile) {
        return stemFile(inputFile, Encoding.UTF_8);
    }

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * returns a <tt>List</tt> of <tt>WordStemmerAnalysis</tt> as result,
     * considering the input encoding.
     * <br>Uses Light10 stemmer.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    @Override
    public final List<WordStemmerAnalysis> stem(final File inputFile,
            final String inputEncoding) {
        return stemFile(inputFile, inputEncoding);
    }

    /**
     * Stems the <tt>String</tt> given in the first parameter and saves
     * results as XML in the output <tt>File</tt> given. The default output
     * language used to present results is English.
     * <br>Uses Light10 stemmer.
     *
     * @param text text to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved
     */
    @Override
    public final void stem(final String text, final File outputFile) {
        List<WordStemmerAnalysis> list = stem(text);
        Utilities.saveStemmingResultAsXML(list, outputFile, Language.ENGLISH);
    }

    /**
     * Stems the <tt>String</tt> given in the first parameter and saves results
     * as XML in the output <tt>File</tt> given, considering the output language
     * chosen.
     * <br>Uses Light10 stemmer.
     *
     * @param text text to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved
     * @param outputLanguage the output language used to present results
     */
    @Override
    public final void stem(final String text, final File outputFile,
            final String outputLanguage) {
        List<WordStemmerAnalysis> list = stem(text);
        Utilities.saveStemmingResultAsXML(list, outputFile, outputLanguage);
    }

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given. The default
     * encoding used for the input <tt>File</tt> is UTF-8 and the default output
     * language used to present results is English.
     * <br>Uses Light10 stemmer.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     */
    @Override
    public final void stem(final File inputFile, final File outputFile) {
        List<WordStemmerAnalysis> list = stemFile(inputFile, Encoding.UTF_8);
        Utilities.saveStemmingResultAsXML(list, outputFile, Language.ENGLISH);
    }

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding chosen in the third  parameter. The default output
     * language used to present results is English.
     * <br>Uses Light10 stemmer.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     */
    @Override
    public final void stem(final File inputFile, final File outputFile,
            final String inputEncoding) {
        List<WordStemmerAnalysis> list = stemFile(inputFile, inputEncoding);
        Utilities.saveStemmingResultAsXML(list, outputFile, Language.ENGLISH);
    }

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding and the output language chosen.
     * <br>Uses Light10 stemmer.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param outputLanguage the output language used to present results
     */
    @Override
    public final void stem(final File inputFile, final File outputFile,
            final String inputEncoding, final String outputLanguage) {
        List<WordStemmerAnalysis> list = stemFile(inputFile, inputEncoding);
        Utilities.saveStemmingResultAsXML(list, outputFile, outputLanguage);
    }

    /* ---------------------------- Utilities  ----------------------------- */
    /**
     * This method is used above by all methods stemming files.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    private List<WordStemmerAnalysis> stemFile(final File inputFile,
            final String inputEncoding) {

        List<WordStemmerAnalysis> list = new ArrayList<WordStemmerAnalysis>();
        StringBuilder sb = new StringBuilder();

        try {
//            URL url = inputFile.toURL();
//            URLConnection connection = url.openConnection();
//            if (connection.getContentType().equals("text/plain")) {
                FileInputStream fis = new FileInputStream(inputFile);
                InputStreamReader ipsr = new InputStreamReader(fis,
                        inputEncoding);
                BufferedReader brd = new BufferedReader(ipsr);
                String in;
                while ((in = brd.readLine()) != null) {
                    sb.append(in);
                    sb.append("\n");
                }
                list = stem(sb.toString());
                brd.close();
                fis.close();
//            } else {
//                Errors.manageError("Error", "The input should be a text file");
//            }
        } catch (Exception e) {
            Errors.manageError("Exception", e.getMessage());
        }
        return list;
    }
}
