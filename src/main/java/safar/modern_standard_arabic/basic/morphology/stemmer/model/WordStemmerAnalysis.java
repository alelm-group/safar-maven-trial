 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.model;

import java.util.List;

/**
 * The <tt>WordStemmerAnalysis</tt> class is used to store all stemming analysis
 * (set of <tt>StemmerAnalysis</tt>) of one word.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author SOUTEH Younes
 * @version 1.0
 * @see StemmerAnalysis
 */
public class WordStemmerAnalysis {

    /** Used to store the original word before stemming. */
    private String word;

    /** Used to store all stemming analysis of the word. */
    private List<StemmerAnalysis> listStemmerAnalysis;

    /**
     * Returns the original word before stemming.
     * @return the original word before stemming
     */
    public final String getWord() {
        return word;
    }

    /**
     * Set the original word to the specified word given in parameter.
     * @param w the original word before stemming
     */
    public final void setWord(final String w) {
        this.word = w;
    }

    /**
     * Returns the <tt>List</tt> of stemming analysis for the word.
     * @return the <tt>List</tt> of stemming analysis
     */
    public final List<StemmerAnalysis> getListStemmerAnalysis() {
        return listStemmerAnalysis;
    }

    /**
     * Set the <tt>List</tt> of stemming analysis to the specified <tt>List</tt>
     * given in parameter.
     * @param stemmerAnalysis <tt>List</tt> of stemming analysis for the word
     */
    public final void setListStemmerAnalysis(
            final List<StemmerAnalysis> stemmerAnalysis) {
        this.listStemmerAnalysis = stemmerAnalysis;
    }

    /**
     * Returns a string representation of the object. In general, the
     * <code>toString</code> method returns a string that "textually represents"
     * this object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return "Word = " + word + ", Stemming_results = "
               + listStemmerAnalysis;
    }
}
