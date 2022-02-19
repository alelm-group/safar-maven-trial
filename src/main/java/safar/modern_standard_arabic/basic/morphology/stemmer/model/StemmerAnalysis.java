 /* SAFAR - Open source programm.additional
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.model;

/**
 * The <tt>StemmerAnalysis</tt> class is used to store one stemming analysis
 * (set of information) about one word.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author SOUTEH Younes
 * @version 1.0
 */
public class StemmerAnalysis {

    /** Used to store the type of the morpheme (ROOT or STEM). */
    private String type;

    /** Used to store the stemmed word. */
    private String morpheme;

    /** Used to store additional information. */
    private String additionalInfo;

    /** Constructs an empty <tt>StemmerAnalysis</tt> object. */
    public StemmerAnalysis() {
    }

    /**
     * Constructs a <tt>StemmerAnalysis</tt> object with the specified type and
     * morpheme.
     *
     * @param t type of the morpheme (ROOT or STEM).
     *          <br>For ROOT use : <tt>Constants.TYPE_ROOT</tt>
     *          <br>For STEM use : <tt>Constants.TYPE_STEM</tt>
     * @param m stemmed word.
     */
    public StemmerAnalysis(final String t, final String m) {
            this.type = t;
            this.morpheme = m;
    }

    /**
     * Returns the type of the morpheme.
     * @return the type of the morpheme
     */
    public final String getType() {
        return type;
    }

    /**
     * Set the type of the stemmed word to the specified type given in
     * parameter.
     * @param t type of the morpheme (ROOT or STEM)
     */
    public final void setType(final String t) {
        this.type = t;
    }

    /**
     * Returns the stemmed word.
     * @return the stemmed word
     */
    public final String getMorpheme() {
        return morpheme;
    }

    /**
     * Set the stemmed word to the specified morpheme given in parameter.
     * @param m the stemmed word.
     */
    public final void setMorpheme(final String m) {
        this.morpheme = m;
    }

    /**
     * Returns additional information (if available).
     * @return additional information (if available)
     */
    public final String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Set additional information to the specified element given in parameter.
     * @param info additional information.
     */
    public final void setAdditionalInfo(final String info) {
        this.additionalInfo = info;
    }

    /**
     * Returns a string representation of the object. In general, the
     * <code>toString</code> method returns a string that "textually represents"
     * this object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
            return "{type = " + type + ", morpheme = " + morpheme
                    + "}";
    }

}
