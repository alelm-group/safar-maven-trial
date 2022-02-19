/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static safar.modern_standard_arabic.basic.syntax.posTagger.util.Attribute.*;

/**
 * The <tt>DecisionTreeModel</tt> class is used to estimate emission probability
 * for unknown words using a Decision Tree Algorithm.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class DecisionTreeModel {
    /** see weka.classifiers.trees.RandomForest. */
    private static J48 myTree;
    /** Used to store all possible Arabic Characters for <tt>SafarLightPOS</tt>. */
    private static List<String> charsValuesAt;
    /** Used to store all possible length values for <tt>SafarLightPOS</tt>. */
    private static List<String> wordLengthValuesAt;
    /** Used to store Tags values for <tt>SafarLightPOS</tt>. */
    private static List<String> tagsValuesAt;
    /**
     * Used to store the attributes for <tt>SafarLightPOS</tt>.
     * see weka.core.FastVector.
     */
    private static FastVector attributes1;
    /**
     * Constructs DecisionTreeModel object and Load the stored model.
     * @throws Exception
     */
    public DecisionTreeModel() throws Exception {
        Data<RandomForest> data = new Data<>();
        Data<J48> dataJ48 = new Data<>();
        DecisionTreeModel.myTree = dataJ48.getData("tree_J48.bin");
        //displayTree();
        setDataLightPOS();
    }

    private void displayTree() throws Exception {
        final javax.swing.JFrame jf =
                new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
        jf.setSize(1200,600);

        jf.getContentPane().setLayout(new BorderLayout());
        TreeVisualizer tv = new TreeVisualizer(null,
                DecisionTreeModel.myTree.graph(),
                new PlaceNode2());
        jf.getContentPane().add(tv, BorderLayout.CENTER);
        jf.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                jf.dispose();
            }
        });
        jf.setVisible(true);
        tv.fitToScreen();
    }

    /**
     * Used by <tt>SafarLightPOS</tt> Distribution of Probability for
     * unknown word given in parameter by decision Tree model using word
     * substring informations.
     *
     * @param word the input unknown word.
     * @return <code>double[]</code> Distribution of Probability
     * @throws Exception
     */
    public static double[] distributionProbabilityForLightPOS(String word) throws Exception {
        double[] values;
        Instances data;
        data = new Instances("MyRelation", attributes1, 0);
        values = new double[data.numAttributes()];
        String length =  word.length()+ "";
        if(word.length() > 20) length = "20";
        values[0] = wordLengthValuesAt.indexOf(length) == -1 ? 0 : wordLengthValuesAt.indexOf(length);
        values[1] = charsValuesAt.indexOf(firstChar(word)) == -1 ? 0 : charsValuesAt.indexOf(firstChar(word)) ;
        values[2] = charsValuesAt.indexOf(lastChar(word)) == -1 ? 0 : charsValuesAt.indexOf(lastChar(word)) ;
        values[3] = charsValuesAt.indexOf(beforeLastChar(word)) == -1 ? 0 : charsValuesAt.indexOf(beforeLastChar(word)) ;
        values[4] = charsValuesAt.indexOf(secondChar(word)) == -1 ? 0 : charsValuesAt.indexOf(secondChar(word)) ;
        values[5] = charsValuesAt.indexOf(thirdChar(word)) == -1 ? 0 : charsValuesAt.indexOf(thirdChar(word)) ;
        values[6] = tagsValuesAt.indexOf("P");
        data.add(new Instance(1.0, values) {});
        data.setClassIndex(data.numAttributes() - 1);
        double[] distributionForInstance = myTree.distributionForInstance(data.firstInstance());
        for (int i = 0; i < distributionForInstance.length; i++) {
            distributionForInstance[i] = i == maxIndex(distributionForInstance) ? 1:0;
        }
        return distributionForInstance;
    }

    public static int maxIndex(double [] array){
        int index = 0 ;
        for (int i = 0; i < array.length; i++) {
            index = array[i] > array[index] ? i : index;
        }
        return index;
    }
    /**
     * Create the arff file declaration for <tt>SafarLightPOS</tt>.
     *
     * @see weka.core.Attribute
     */
    private static void setDataLightPOS() {
        List<String> attValues =  new ArrayList<>(Arrays.asList("|،|", "|ـ|", "|…|", "|‌|", 
        "|‍|", "||‏|", "|.|", ".|", "||", "|ا|", "|ب|", "|ت|", "|ث|", "|ج|", 
        "|ح|", "|خ|", "|د|", "|ذ|", "|ر|", "|ز|", "|س|", "|ش|", "|ص|", "|ض|",
        "|ط|", "|ظ|", "|ع|", "|غ|", "|ف|", "|ق|", "|ك|", "|ل|", "|م|", "|ن|",
        "|ه|", "|و|", "|ي|", "|ء|", "|أ|", "|إ|", "|آ|", "|ة|", "|ؤ|", "|ئ|",
        "|ى|", "|‏|", /**/ "0", "1", "2", "3", "4", 
        "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
        "18", "19", "20", "21",/**/"V", "N", "punct", "P"));
        Data<List<String>> dataAttValues = new Data<>();
        List<String> attValues1 =   dataAttValues.getData("attValues.data");
        attributes1 = new FastVector();
        /*charsValuesAt = Arrays.asList("|،|", "|ـ|", "|…|", "|‌|", 
        "|‍|", "||‏|", "|.|", ".|", "||", "|ا|", "|ب|", "|ت|", "|ث|", "|ج|", 
        "|ح|", "|خ|", "|د|", "|ذ|", "|ر|", "|ز|", "|س|", "|ش|", "|ص|", "|ض|",
        "|ط|", "|ظ|", "|ع|", "|غ|", "|ف|", "|ق|", "|ك|", "|ل|", "|م|", "|ن|",
        "|ه|", "|و|", "|ي|", "|ء|", "|أ|", "|إ|", "|آ|", "|ة|", "|ؤ|", "|ئ|",
        "|ى|", "|‏|");
        wordLengthValuesAt = Arrays.asList("0", "1", "2", "3", "4", 
        "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
        "18", "19", "20", "21");
        tagsValuesAt = Arrays.asList("V", "N", "punct", "P");*/
        charsValuesAt =  new ArrayList<>(attValues1.subList(0, 46));
        wordLengthValuesAt =  new ArrayList<>(attValues1.subList(46, 68));
        tagsValuesAt = new ArrayList<>(attValues1.subList(68,attValues.size()) )  ;

        FastVector chars = new FastVector(), lent = new FastVector(), tags = new FastVector();
        charsValuesAt.forEach((charValue) -> {
            chars.addElement(charValue);
        });
        tagsValuesAt.forEach((tag) -> {
            tags.addElement(tag);
        });
        wordLengthValuesAt.forEach((lengths) -> {
            lent.addElement(lengths);
        });
        attributes1.addElement(new weka.core.Attribute("sizeAt", lent));
        attributes1.addElement(new weka.core.Attribute("b", chars));
        attributes1.addElement(new weka.core.Attribute("c", chars));
        attributes1.addElement(new weka.core.Attribute("d", chars));
        attributes1.addElement(new weka.core.Attribute("e", chars));
        attributes1.addElement(new weka.core.Attribute("f", chars));
        attributes1.addElement(new weka.core.Attribute("tags", tags));
    }
}
