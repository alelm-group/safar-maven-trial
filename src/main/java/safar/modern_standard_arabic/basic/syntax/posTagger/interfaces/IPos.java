/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.interfaces;

import safar.modern_standard_arabic.basic.syntax.posTagger.model.WordPOSAnalysis;

import java.io.File;
import java.util.List;
/**
 * The IPos interface is used to describe the minimum structure that POS taggers
 * should have in order to be valid implementations
 * in SAFAR platform.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public interface IPos {
    /**
     * List Of (results) sentences SentencePosAnalysis.
     * @param text input text to tag (Tag)
     * @return result of implémentation
     */
    List<WordPOSAnalysis> tag(String text);
    /**
     * tag the content of the <tt>File</tt> given in parameter and returns a
     * <tt>List</tt> of <tt>WordPOSAnalysis</tt> as result.
     * The default encoding used for the input <tt>File</tt> is UTF-8.
     *
     * @param inputFile <tt>File</tt> to be tag
     * @return <tt>List</tt> of <tt>WordPOSAnalysis</tt>
     */
    List<WordPOSAnalysis> tag(File inputFile);
    /**
     * tag the content of the <tt>File</tt> given in the first parameter and
     * returns a <tt>List</tt> of <tt>WordPOSAnalysis</tt> as result,
     * considering the input encoding.
     *
     * @param inputFile <tt>File</tt> to be tag
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return <tt>List</tt> of <tt>WordPOSAnalysis</tt>
     */
    List<WordPOSAnalysis> tag(File inputFile, String inputEncoding);
    /**
     * tag the <tt>String</tt> given in the first parameter and saves
     * results as XML in the output <tt>File</tt> given. The default output
     * language used to present results is English.
     *
     * @param text text to be tag
     * @param outputFile <tt>File</tt> in which results will be saved
     */
     void tag(String text, File outputFile);
    /**
     * tag the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given. The default
     * encoding used for the input <tt>File</tt> is UTF-8 and the default output
     *
     * @param inputFile <tt>File</tt> to be tag
     * @param outputFile <tt>File</tt> in which results will be saved.
     */
     void tag(File inputFile, File outputFile);
    /**
     * tag the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding chosen in the third  parameter. The default output
     * language used to present results is English.
     *
     * @param inputFile <tt>File</tt> to be tag
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     */
    void tag(File inputFile, File outputFile, String inputEncoding);

}
