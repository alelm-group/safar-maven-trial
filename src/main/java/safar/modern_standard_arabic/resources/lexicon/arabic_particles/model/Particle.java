package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;
import java.util.List;

/**The <tt> Particle </tt> class is used to
 * store one particle object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Particle {
    /** Used to store the mclasses list. */
    private ArrayList mclasses = new ArrayList();
    /** Used to store the Particle unvoweledform. */
    private String unvoweledform;
    /** Used to store the Particle voweledform. */
    private String voweledform;
    /** Constructs an empty <tt>Particle</tt> object. */
    public Particle() {
    /**
     * Constructs a <tt> Particle </tt> object with the specified voweled,
     * voweledform and mclasses.
     *
     */
    }
    /**
     * Get the Unvoweledform of the Particle.
     * @return unvoweledform of the Particle
     */
    public final String getUnvoweledform() {
        return unvoweledform;
    }
    /** Set the Particle object Unvoweledform
     * to the specified value given in parameter.
     * @param uform a Strings containing the object Unvoweledform
     */
    public final void setUnvoweledform(final String uform) {
        this.unvoweledform = uform;
    }
    /**
     * Get the voweledform of the Particle.
     * @return voweledform of the Particle
     */
    public final String getVoweledform() {
        return voweledform;
    }
    /** Set the Particle object voweledform
     * to the specified value given in parameter.
     * @param vform a Strings containing the object voweledform
     */
    public final void setVoweledform(final String vform) {
        this.voweledform = vform;
    }
    /**
     * Get the list of the Particle <code>MClasses</code>.
     * @return the list of the Particle MClasses
     */
    public final List getMClasses() {
        return mclasses;
    }
    /**
     * add a MClass to the Particle.
     * @param myclass a MClass object
     */
    public final void addMClass(final MClass myclass) {
        mclasses.add(myclass);
    }
    /**
     * Set the Particle object MClasses
     * to the specified value given in parameter.
     * @param letters a Strings containing the MClasses
     */
    public final void setMClasses(final ArrayList letters) {
        this.mclasses = letters;
    }
     /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return unvoweledform + " " + voweledform;
    }
}