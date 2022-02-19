package safar.modern_standard_arabic.basic.syntax.posTagger.util;
/**
 * The Viterbi class is used to apply the Viterbi algorithm on a sentence.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class Viterbi {
    /**
     * Return the most probable tag sequence for
     * the given sentence in parameter.
     * @param sentence input sentence
     * @param tags tags List
     * @param startProb start probability for sentence
     * @param transitionProb transition probability for sentence
     * @param emissionProb emission probability for sentence
     * @return most probable tag sequence
     */
    public String[] forwardViterbi(String[] sentence,String[] tags,
            double[] startProb, double[][] transitionProb,
            double[][] emissionProb) {
        TreeNode[] T = new TreeNode[tags.length];
        for (int state = 0; state < tags.length; state++) {
            int[] intArray = new int[1];
            intArray[0] = state;
            T[state] = new TreeNode(intArray,
                    startProb[state] * emissionProb[0][state]);
        }
        for (int output = 1; output < sentence.length; output++) {
            TreeNode[] U = new TreeNode[tags.length];
            for (int nextState = 0; nextState < tags.length; nextState++) {
                int[] argmax = new int[0];
                double valmax = 0;
                for (int state = 0; state < tags.length; state++) {
                    int[] viterbiPathArray = copyIntArray(T[state].viterbiPath);
                    double viterbiProbability = T[state].viterbiProb;
                    double p = emissionProb[output][nextState]
                            * transitionProb[state][nextState];
                    viterbiProbability *= p;
                    if (viterbiProbability > valmax) {
                        if (viterbiPathArray.length == sentence.length) {
                            argmax = copyIntArray(viterbiPathArray);
                        } else {
                            argmax = copyIntArray(viterbiPathArray, nextState);
                        }
                        valmax = viterbiProbability;
                    }
                }
                U[nextState] = new TreeNode(argmax, valmax);
            }
            T = U;
        }
        int[] argmax = new int[0];
        double valmax = 0;
        for (int state = 0; state < tags.length; state++) {
            int[] viterbiPath = copyIntArray(T[state].viterbiPath);
            double viterbiProbability = T[state].viterbiProb;
            if (viterbiProbability > valmax) {
                argmax = copyIntArray(viterbiPath);
                valmax = viterbiProbability;
            }
        }
        String tagsSequence[];
        tagsSequence = new String[argmax.length];
        for (int i = 0; i < argmax.length; i++) {
            tagsSequence[i] = tags[argmax[i]];
        }
     return tagsSequence;
    }
    
    /**
     * The TreeNode class is used to get the Viterbi path.
     */
    private static class TreeNode { 
        private final int[] viterbiPath;
        private final double viterbiProb;
        /**
         * Constructs a TreeNode object with the specified Viterbi Path and Viterbi Probability.
         */
        public TreeNode(int[] viterbiPath, double viterbiProb) {
            this.viterbiPath = copyIntArray(viterbiPath);
            this.viterbiProb = viterbiProb;
        }
    }
    private static int[] copyIntArray(int[] array) {
        int[] newArray = new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
    /**
     * Used to save the Viterbi path states' index
     * @param array The input array.
     * @param nextState The next state index to add.
     * @return new integer Array with one additionel elements
     */
    private static int[] copyIntArray(int[] array, int nextState) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = nextState;
        return newArray;
    }
    
}
