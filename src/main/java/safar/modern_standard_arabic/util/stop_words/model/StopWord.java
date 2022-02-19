package safar.modern_standard_arabic.util.stop_words.model;



/**The <tt> StopWord </tt> class is used to
 * store one stopWord object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class StopWord {
    /** Used to store the StopWord voweledform. */
    private String voweledform;
    /** Used to store the StopWord unvoweledform. */
    private String unvoweledform;
    /** Used to store the StopWord prefix. */
    private String pref;
    /** Used to store the StopWord simpleSW. */
    private String simpleSW;
    /** Used to store the StopWord suffix. */
    private String suff;
    /** Constructs an empty <tt>StopWord</tt> object. */
    public StopWord() {
    /**
     * Constructs a <tt> StopWord </tt> object with the specified voweled,
     * voweledform and mclasses.
     *
     */
    }

    /**
     * @return the voweledform
     */
    public final String getVoweledform() {
        return voweledform;
    }

    /**
     * @param vform the voweledform to set
     */
    public final void setVoweledform(final String vform) {
        this.voweledform = vform;
    }
    
    /**
     * @return the voweledform
     */
    public final String getUnvoweledform() {
        return unvoweledform;
    }

    /**
     * @param uform the voweledform to set
     */
    public final void setUnvoweledform(final String uform) {
        this.unvoweledform = uform.replaceAll("[ًٌٍَُِّْ ]", "");
    }

    /**
     * @return the prefix
     */
    public final String getPref() {
        return pref;
    }

    /**
     * @param prefix the prefix to set
     */
    public final void setPref(final String prefix) {
        this.pref = prefix;
    }

    /**
     * @return the simpleSW
     */
    public final String getSimpleSW() {
        return simpleSW;
    }

    /**
     * @param sSW the simpleSW to set
     */
    public final void setSimpleSW(final String sSW) {
        this.simpleSW = sSW;
    }

    /**
     * @return the suffix
     */
    public final String getSuff() {
        return suff;
    }

    /**
     * @param suffix the suffix to set
     */
    public final void setSuff(final String suffix) {
        this.suff = suffix;
    }

     /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return voweledform + " " + pref + " " + simpleSW + " " + suff;
    }
}