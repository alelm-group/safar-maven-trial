/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.model;

/**
 * The <tt>WordPOSAnalysis</tt> class is used to store all POS Tagging analysis
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class WordPOSAnalysis {

    /** The word tagged. */
    private String word;
    /** The Tag(the output). */
    private String tag;
    /**
     * Constructs a PosAnalysis object with the specified word and tag.
     * @param word the word tagged.
     * @param tag the output tag.
     */
    public WordPOSAnalysis(final String word, final String tag) {
        this.word = word;
        this.tag = tag;
    }
    
    /** Constructs an empty PosAnalysis object. */
    public WordPOSAnalysis() {    
    }

    /**
     * Set the word to analyze.
     * @param word the tagged word.
     */
    public final void setWord(final String word) {
        this.word = word;
    }

    /**
     * Set the tag(analysis) of the word.
     * @param tag the tag of the word.
     */
    public final void setTag(final String tag) {
        this.tag = tag;
    }

    /**
     * Returns the tagged word.
     * @return Word the tagged word.
     */
    public final String getWord() {
        return word;
    }

    /**
     * Returns the word's tag.
     * @return The Tag of the word.
     */
    public final String getTag() {
        return tag;
    }

    @Override
    public final String toString() {
        return word + "_" + tag;
    }
}
