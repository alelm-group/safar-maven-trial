package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

/**The <tt>Radical</tt>class is used to store one specialVerb radical.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Radical implements java.io.Serializable {
    /** Used to store the radical voweledForm. */
    private String voweledForm;
    /** Used to store the radical unvoweledForm . */
    private String unVoweledForm;
    /** Used to store the radical tenses. */
    private String tenses;
    /** Used to store the radical conjSuffix . */
    private String conjSuffix;
    /** Used to store the radical prefix Vowel . */
    private String preVow;

    /** Constructs an empty <tt>Radical</tt> object. */
    public Radical() {
        /**
     * Constructs a <tt>Radical</tt> object with the specified
     * voweledForm, unvoweledForm, tenses and conjSuffix.
     *
     */
    }
    /**
     * Returns the voweledForm of the Radical.
     * @return voweledForm Radical voweledForm
     */
   public final String getVoweledForm() {
        return voweledForm;
    }
   /**
     * Set the Radical object voweledForm
     * to the specified value given in parameter.
     * @param voweled a Strings containing the object voweledForm
     */
    public final void setVoweledForm(final String voweled) {
        this.voweledForm = voweled;
    }
    /**
     * Returns the unvoweledForm of the Radical.
     * @return unvoweled Radical unvoweledForm
     */
   public final String getUnVoweledForm() {
        return unVoweledForm;
    }
   /**
     * Set the Radical object unvoweled
     * to the specified value given in parameter.
     * @param unvoweled a Strings containing the object unvoweledForm
     */
    public final void setUnVoweledForm(final String unvoweled) {
        this.unVoweledForm = unvoweled;
    }
    /**
     * Returns the tenses  of the Radical.
     * @return tense Radical tenses
     */
    public final String getTenses() {
        return tenses;
    }
    /**
     * Set the Radical object tenses
     * to the specified value given in parameter.
     * @param ten a Strings containing the object tenses
     */
    public final void setTenses(final String ten) {
        this.tenses = ten;
    }
    /**
     * Returns the preVow  of the Radical.
     * @return Radical preVow
     */
    public final String getPreVow() {
        return preVow;
    }
    /**
     * Set the Radical object preVow
     * to the specified value given in parameter.
     * @param pV a Strings containing the preVow object
     */
    public final void setPreVow(final String pV) {
        this.preVow = pV;
    }
    /**
     * Returns the conjSuffix  of the Radical.
     * @return tense Radical conjSuffix
     */
    public final String getConjSuffix() {
        return conjSuffix;
    }
    /**
     * Set the Radical object conjSuffix
     * to the specified value given in parameter.
     * @param cA a Strings containing the object conjSuffix
     */
    public final void setConjSuffix(final String cA) {
        this.conjSuffix = cA;
    }
    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return  voweledForm + " ; " + unVoweledForm + " ; " + preVow + " ; "
                + tenses + " ; " + conjSuffix;
    }
}