package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;


/**The <tt> PerfectItem </tt> class is used to
 * store one Perfect Item object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Item {
    /** Used to store the pMorphPptes list. */
    private String pPId;
    /** Used to store the Item unvoweledform. */
    private String unvoweledform;
    /** Used to store the Item voweledform. */
    private String voweledform;
    /** Constructs an empty <tt>Item</tt> object. */
    public Item() {
    /**
     * Constructs a <tt> Perfect Item </tt> object with the specified voweled,
     * voweledform and MorphPptes.
     *
     */
    }
    /**
     * Returns the pPId of the Item.
     * @return pPId of the Item
     */
    public final String getPPId() {
        return pPId;
    }
    /** Set the Item object pPId
     * to the specified value given in parameter.
     * @param id a Strings containing the object pPId
     */
    public final void setPPId(final String id) {
        this.pPId = id;
    }
    /**
     * Returns the Unvoweledform of the Item.
     * @return unvoweledform of the Item
     */
    public final String getUnvoweledform() {
        return unvoweledform;
    }
    /** Set the Item object Unvoweledform
     * to the specified value given in parameter.
     * @param uform a Strings containing the object Unvoweledform
     */
    public final void setUnvoweledform(final String uform) {
        this.unvoweledform = uform;
    }
    /**
     * Returns the voweledform of the Item.
     * @return voweledform of the Item
     */
    public final String getVoweledform() {
        return voweledform;
    }
    /** Set the Item object voweledform
     * to the specified value given in parameter.
     * @param vform a Strings containing the object voweledform
     */
    public final void setVoweledform(final String vform) {
        this.voweledform = vform;
    }

     /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return unvoweledform + " " + voweledform + " " + pPId;
    }
}
