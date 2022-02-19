 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.util;

import common.manage_errors.Errors;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import safar.modern_standard_arabic.basic.morphology.stemmer.model
        .StemmerAnalysis;
import safar.modern_standard_arabic.basic.morphology.stemmer.model
        .WordStemmerAnalysis;

/**
 * The <tt>Utilities</tt> class is a set of static methods that are mainly
 * used as utilities for the classes in <tt>stemmer</tt> package, but can
 * also be called by all of other classes outside the package.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author SOUTEH Younes
 * @version 1.0
 */
public abstract class Utilities {

    /**
     * Saves the content of the specified <tt>List</tt> of
     * <tt>WordStemmerAnalysis</tt> in XML format in the ouput <tt>File</tt>
     * given, considering the output language chosen.
     *
     * @param stemmingResult <tt>List</tt> of <tt>WordStemmerAnalysis</tt> that
     *                       will be saved
     * @param outputFile <tt>File</tt> in which XML output will be saved
     * @param outputLanguage the output language used to present results
     */
    public static void saveStemmingResultAsXML(
            final List<WordStemmerAnalysis> stemmingResult,
            final File outputFile, final String outputLanguage) {
        Locale locale = new Locale(outputLanguage.split(",")[0],
                outputLanguage.split(",")[1]);
        ResourceBundle  captions = ResourceBundle.getBundle("Messages", locale);

        Element rootAnalysis = new Element(
                captions.getString("stemmerAnalysis"));

        rootAnalysis.setAttribute(new Attribute(
                captions.getString("totalWords"), stemmingResult.size() + ""));

        Document doc = new Document(rootAnalysis);
       //word id
        int i = 1;
        for (WordStemmerAnalysis wordStemmerAnalysis : stemmingResult) {
            if (wordStemmerAnalysis != null) {
                Element word = new Element(captions.getString("word"));
                word.setAttribute(new Attribute(
                        captions.getString("wordId"), i++ + ""));
                word.setAttribute(new Attribute(captions.getString("value"),
                        wordStemmerAnalysis.getWord()));
                if (wordStemmerAnalysis.getListStemmerAnalysis() != null
                        || !wordStemmerAnalysis.getListStemmerAnalysis()
                                .isEmpty()) {
                    for (StemmerAnalysis stemmerAnalysis : wordStemmerAnalysis
                                .getListStemmerAnalysis()) {
                        Element analysis = new Element(
                                captions.getString("analysis"));
                        analysis.setAttribute(new Attribute(
                                captions.getString("stem"),
                                stemmerAnalysis.getMorpheme() + ""));
                        analysis.setAttribute(new Attribute(
                                captions.getString("type"),
                                stemmerAnalysis.getType() + ""));
                        word.addContent(analysis);
                    }
                    doc.getRootElement().addContent(word);
                }
            }
        }
        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
        try {
            xmlOutput.output(doc, new FileWriter(outputFile));
        } catch (IOException e) {
            Errors.manageError("Exception", e.getMessage());
        }
    }
}
