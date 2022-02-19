package safar.modern_standard_arabic.basic.syntax.posTagger.util;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class HMM implements Serializable {

    private List<String> vocabulary;
    /** Used to Store the tag set. */
    private List<String> tagsList ;
    private double[][] transitionProbabilityArray ;
    /** Used to Store the emission Probability. */
    private double[][] emissionProbabilityArray ;
    /** Used to Store the start Probability. */
    private double[] startProbability;
    
    public List<String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(List<String> vocabulary) {
        this.vocabulary = vocabulary;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public double[][] getTransitionProbabilityArray() {
        return transitionProbabilityArray;
    }

    public void setTransitionProbabilityArray(double[][] transitionProbabilityArray) {
        this.transitionProbabilityArray = transitionProbabilityArray;
    }

    public double[][] getEmissionProbabilityArray() {
        return emissionProbabilityArray;
    }

    public void setEmissionProbabilityArray(double[][] emissionProbabilityArray) {
        this.emissionProbabilityArray = emissionProbabilityArray;
    }

    public double[] getStartProbability() {
        return startProbability;
    }

    public void setStartProbability(double[] startProbability) {
        this.startProbability = startProbability;
    }
    
}
