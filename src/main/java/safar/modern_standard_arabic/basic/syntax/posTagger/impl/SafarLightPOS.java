/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.impl;

import common.constants.Encoding;
import common.constants.Language;
import safar.modern_standard_arabic.basic.syntax.posTagger.interfaces.IPos;
import safar.modern_standard_arabic.basic.syntax.posTagger.model.WordPOSAnalysis;
import safar.modern_standard_arabic.basic.syntax.posTagger.util.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static safar.modern_standard_arabic.basic.syntax.posTagger.util.PreprocessingSentence.*;
import static safar.modern_standard_arabic.basic.syntax.posTagger.util.SaveResultAsXML.savePOSAnalysisResultAsXML;

/**
 * The <tt>SafarLightPOS</tt> class is an implementation of <tt>IPos</tt>
 * interface.
 * <br/>It concerns Safar Light POS Tagger implementation.
 * <br/>To get an instance of this class, it's better to go through
 * <tt>PosFactory</tt> class instead of instantiating it directly.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class SafarLightPOS implements IPos{
    /** Used to Store the start Probability. */
    private double[] startProbability;
    /** Used to Store the vocabulary. */
    private List<String> vocabulary;
    /** Used to Store the tag set. */
    private List<String> tagsList ;
    /** Used to store the index of eache word in the vocabulary. */
    private static List<Integer> sentenceWordsIndexes;
    /** Used to Store the transition Probability. */
    private double[][] transitionProbabilityArray ;
    /** Used to Store the émission Probability. */
    private double[][] emissionProbabilityArray ;
    /** Used to Store HMM mode*/
    public static HMM hmm;
    /** Used to store the sentences of the input text. */
    private static String[] sentence;
    /** */
    public SafarLightPOS() {
        try {
            Data<HMM> hmmData = new Data<>();
            hmm = hmmData.getData("hmmSafarLightPOS.model");
            startProbability = hmm.getStartProbability();
            transitionProbabilityArray = hmm.getTransitionProbabilityArray();
            emissionProbabilityArray = hmm.getEmissionProbabilityArray();
            tagsList = hmm.getTagsList();
            vocabulary = hmm.getVocabulary();
            DecisionTreeModel T = new DecisionTreeModel();
        } catch (Exception ex) {
            Logger.getLogger(SafarLightPOS.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    /**
     * tag the input text given in parameter
 and returns doubleArray List of SentencePosAnalysis as result.
     * @param text input text to tag
     * @return WordPOSAnalysis
     */
    @Override
    public final List<WordPOSAnalysis> tag(String text) {
        List<WordPOSAnalysis> wordPosAnalysis = new ArrayList<>();
        text = stringNormalizer(text);
        String[] sentences = sentenceSplitterUpdated(text);
        for (String sentence1 : sentences) {
            sentence = sentence1.split(" ");
            sentenceWordsIndexes = sentenceWordsIndexes(sentence, vocabulary);
            try {
                String[] tags = getPOSImplementation(sentence);
                for (int i = 0; i < sentence.length; i++) {
                    WordPOSAnalysis wordTag = new WordPOSAnalysis();
                    wordTag.setTag(tags[i]);
                    wordTag.setWord(sentence[i]);
                    wordPosAnalysis.add(wordTag);
                }
            } catch (Exception ex) {
                System.err.println(sentence[0]);
                Logger.getLogger(SafarLightPOS.class.getName())
                        .log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return wordPosAnalysis;
    }

    /**
     * The <tt>HiddenMarkovModel and Decsuon Tree Model</tt> 
     * class is doubleArray set of POS utilities allowing Safar implementations.
     * Returns the most probable tag sequence for the given sentence in parameter
     * @param sentence sentence to be tagged
     * @return The most probable tag sequence
     * @throws Exception
     */
    public final String[] getPOSImplementation(String sentence[]) throws Exception {
        String tagsS[];
        double[] classifyDistribution;
        int absent = 0;
        for (int i = 0; i < sentence.length; i++) {
            if (sentenceWordsIndexes.get(i) == -1) {
                absent++;
            }
        }
        String states[] = tagsList.toArray(new String[tagsList.size()]);
        Viterbi viterbi = new Viterbi();
        double ep[][] = EmissiomForSentence.emissiomForSentence(sentence, 
                emissionProbabilityArray, tagsList, sentenceWordsIndexes);
        boolean prb = true;
        if (absent == 0 ) {
            tagsS = viterbi.forwardViterbi(sentence, states,
                    startProbability, transitionProbabilityArray, ep);
        } else {
            for (int i = 0; i < sentence.length; i++) {
                if (sentenceWordsIndexes.get(i) == -1) {
                    classifyDistribution =
                            DecisionTreeModel.distributionProbabilityForLightPOS(sentence[i]);
                    ep[i] = classifyDistribution;
                }
            }
            tagsS = viterbi.forwardViterbi(sentence, states,
                    startProbability, transitionProbabilityArray, ep);
        }
        return tagsS;
    }
    /**
     * tag the content of the <tt>File</tt> given in parameter and returns a
     * <tt>List</tt> of <tt>WordPOSAnalysis</tt> as result.
     * <br/>Uses Safar Light POS for analyzing, 
     * results are then transformed to
     * <tt>WordPOSAnalysis</tt> objects.
     *
     * @param inputFile <tt>File</tt> to be analyzed
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return <tt>List</tt> of <tt>WordPOSAnalysis</tt>
     */
    @Override
    public final List<WordPOSAnalysis> tag(File inputFile, String inputEncoding) {
        String text = "";
        try {
            Scanner input = new Scanner(inputFile, inputEncoding);
            while (input.hasNext()) {
            text += input.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SafarLightPOS.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
        
       return tag(text);
    }
    /**
     * tag the content of the <tt>File</tt> given in parameter and returns a
     * <tt>List</tt> of <tt>WordPOSAnalysis</tt> as result.
     * <br/>The default encoding used for the input <tt>File</tt> is UTF-8.
     * <br/>Uses Safar Light POS for analyzing, 
     * results are then transformed to
     * <tt>WordPOSAnalysis</tt> objects.
     *
     * @param inputFile <tt>File</tt> to be tag
     * @return <tt>List</tt> of <tt>WordPOSAnalysis</tt>
     */
    @Override
    public final List<WordPOSAnalysis> tag(File inputFile) {
     String text = "";
        try {
            Scanner input = new Scanner(inputFile, Encoding.UTF_8);
            while (input.hasNext()) {
            text += input.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SafarLightPOS.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
        
       return tag(text);
    }
    /**
     * tag the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given.
     * <br>The default encoding used for the input <tt>File</tt> is UTF-8 and
     * the default output language used to present results is English.
     * <br/>Uses Safar Light POS.
     *
     * @param inputFile <tt>File</tt> to be analyzed
     * @param outputFile <tt>File</tt> in which results will be saved.
     */
    @Override
    public final void tag(File inputFile, File outputFile) {
        tag(inputFile,outputFile,Encoding.UTF_8);
    }
    /**
     * tag the <tt>String</tt> given in the first parameter and saves
     * results as XML in the output <tt>File</tt> given. The default output
     * language used to present results is English.
     * <br/>Uses Safar Light POS.
     *
     * @param text text to be analyzed
     * @param outputFile <tt>File</tt> in which results will be saved
     */
    @Override
    public final void tag(String text, File outputFile){
        List<WordPOSAnalysis> wordPosAnalysis  = tag(text);
        savePOSAnalysisResultAsXML(wordPosAnalysis, outputFile, Language.ENGLISH);
    }   
    /**
     * tag the content of the <tt>File</tt> given in the first parameter and
     * saves results as XML in the output <tt>File</tt> given, considering the
     * input encoding chosen in the third  parameter. The default output
     * language used to present results is English.
     * <br/>Uses Safar Light POS.
     *
     * @param inputFile <tt>File</tt> to be analyzed
     * @param outputFile <tt>File</tt> in which results will be saved.
     * @param inputEncoding encoding of the input <tt>File</tt>
     */
    @Override
    public final void tag(File inputFile, File outputFile, String inputEncoding) {
        String text = "";
        try {
            Scanner input = new Scanner(inputFile, inputEncoding);
            while (input.hasNext()) {
            text += input.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SafarLightPOS.class.getName())
                    .log(Level.SEVERE, ex.getMessage(), ex);
        }
        List<WordPOSAnalysis> wordPosAnalysis  = tag(text);
        savePOSAnalysisResultAsXML(wordPosAnalysis, outputFile, Language.ENGLISH);
    } 
}
