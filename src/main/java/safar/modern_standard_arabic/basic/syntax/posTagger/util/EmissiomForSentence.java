/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import java.util.List;

/**
 * The <tt>emissionForSentence</tt> class is used to create an
 * emissionProbability array
 * for sentences to analyze with Viterbi algorithm.
 * @see Viterbi
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public abstract class EmissiomForSentence {

    /**
     * Returns Emission Probability Array for the sentence given in parameter.
     * @param sentence input sentence
     * @param emissionProbabilityArray Emission Probability Array of All vocabulary
     * @param tagsList the tags List
     * @param sentanceWordsIndexs index of sentence's Words in the vocabulary
     * @return Emission Probability Array for input sentence
     */
    public static double[][] emissiomForSentence(String sentence[],
            double emissionProbabilityArray[][], List<String> tagsList,
            List<Integer> sentanceWordsIndexs) {
        double emissionProbabilityArrayForSentences[][]
                = new double[sentence.length][tagsList.size()];
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < tagsList.size(); j++) {
                emissionProbabilityArrayForSentences[i][j] = 0;
            }
        }
        for (int i = 0; i < emissionProbabilityArrayForSentences.length; i++) {
            int index = sentanceWordsIndexs.get(i);
            if (index != -1) {
                emissionProbabilityArrayForSentences[i] = emissionProbabilityArray[index];
            }
        }
        return emissionProbabilityArrayForSentences;
    }
   
}
