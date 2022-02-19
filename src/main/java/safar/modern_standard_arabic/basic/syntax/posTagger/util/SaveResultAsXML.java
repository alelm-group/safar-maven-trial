/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import common.manage_errors.Errors;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import safar.modern_standard_arabic.basic.syntax.posTagger.model.WordPOSAnalysis;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * The <tt>SaveResultAsXML</tt> class is a set of static methods that are mainly
 * used as utilities for the classes in <tt>POS Tagger</tt> package, but can
 * also be called by all of other classes outside the package.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public abstract class SaveResultAsXML {

    /**
     * Saves the content of the specified <tt>List</tt> of
     * <tt>WordPOSAnalysis</tt> in XML format in the output <tt>File</tt>
     * given, considering the output language chosen.
     *
     * @param posResult <tt>List</tt> of <tt>WordPOSAnalysis</tt> that will be
     * saved
     * @param outputFile <tt>File</tt> in which XML output will be saved
     * @param outputLanguage the output language used to present results
     */
    public static void savePOSAnalysisResultAsXML(
            final List<WordPOSAnalysis> posResult, final File outputFile,
            final String outputLanguage) {
        Locale locale = new Locale(outputLanguage.split(",")[0],
                outputLanguage.split(",")[1]);
        ResourceBundle captions = ResourceBundle.getBundle("Messages", locale);
        Element rootAnalysis = new Element("text");
        rootAnalysis.setAttribute(new org.jdom2.Attribute(
                captions.getString("totalWords"), posResult.size() + ""));
        Document doc = new Document(rootAnalysis);
        int i = 1 , o = 1;
        List<String> stopPunct = Arrays.asList(".", "!", "?", "؟");
        List<WordPOSAnalysis> sentence = new ArrayList<>();
        for (int m = 0; m < posResult.size(); m++) {
            String w = posResult.get(m).toString().split("_")[0];
            if (!stopPunct.contains(w) && m != posResult.size() - 1) {
                sentence.add(posResult.get(m));
            } else {
                sentence.add(posResult.get(m));
                Element sentenceXML = new Element("sentence");
                sentenceXML.setAttribute(new org.jdom2.Attribute(
                        "sentenceID", o++ + ""));
                for (WordPOSAnalysis wordPosAnalysis : sentence) {
                    Element word = new Element(captions.getString("word"));
                    if (wordPosAnalysis != null) {
                        word.setAttribute(new org.jdom2.Attribute(
                                captions.getString("wordId"), i++ + ""));
                        word.setAttribute(new org.jdom2.Attribute(
                                captions.getString("value"),
                                wordPosAnalysis.getWord()));
                        Element analysis = new Element(captions.getString("analysis"));
                        analysis.setAttribute(
                                new org.jdom2.Attribute(captions.getString("pos"),
                                        wordPosAnalysis.getTag() + ""));
                        word.addContent(analysis);
                    }
                    sentenceXML.addContent(word);
                }
                doc.getRootElement().addContent(sentenceXML);
                sentence.clear();
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
