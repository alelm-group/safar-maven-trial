 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.interfaces;

import java.io.File;
import java.util.List;
import safar.modern_standard_arabic.basic.morphology.stemmer.model
        .WordStemmerAnalysis;

/**
 * The <tt>IStemmer</tt> interface is used to describe the minimum structure
 * that stemmers should have in order to be valid implementations in SAFAR
 * platefome.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author SOUTEH Younes
 * @version 1.0
 */
public interface IStemmer {

    /**
     * Stems the <tt>String</tt> given in parameter and returns a <tt>List</tt>
     * of <tt>WordMorphologyAnalysis</tt> as result.
     *
     * @param text text to be stemmed
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    List<WordStemmerAnalysis> stem(String text);

    /**
     * Stems the content of the <tt>File</tt> given in parameter and returns a
     * <tt>List</tt> of <tt>WordStemmerAnalysis</tt> as result.
     * <br>The default encoding used for the input <tt>File</tt> is UTF-8.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    List<WordStemmerAnalysis> stem(File inputFile);

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * returns a <tt>List</tt> of <tt>WordStemmerAnalysis</tt> as result,
     * considering the input encoding.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return <tt>List</tt> of <tt>WordStemmerAnalysis</tt>
     */
    List<WordStemmerAnalysis> stem(File inputFile, String inputEncoding);

    /**
     * Stems the <tt>String</tt> given in the first parameter and saves
     * results as XML in the output <tt>File</tt> given. The default output
     * language used to present results is English.
     *
     * @param text text to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved
     */
    void stem(String text, File outputFile);

    /**
     * Stems the <tt>String</tt> given in the first parameter and saves results
     * as XML in the output <tt>File</tt> given, considering the output language
     * chosen.
     *
     * @param text text to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved
     * @param outputLanguage the output language used to present results
     */
    void stem(String text, File outputFile, String outputLanguage);

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given. The default
     * encoding used for the input <tt>File</tt> is UTF-8 and the default output
     * language used to present results is English.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     */
    void stem(File inputFile, File outputFile);

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding chosen in the third  parameter. The default output
     * language used to present results is English.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     */
    void stem(File inputFile, File outputFile, String inputEncoding);

    /**
     * Stems the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding and the output language chosen.
     *
     * @param inputFile <tt>File</tt> to be stemmed
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param outputLanguage the output language used to present results
     */
    void stem(File inputFile, File outputFile, String inputEncoding,
            String outputLanguage);
}
