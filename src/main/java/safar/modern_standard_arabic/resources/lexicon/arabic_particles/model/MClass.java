package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;
import java.util.List;


/**The <tt> MClass </tt> class is used to
 * store one particle morphological Class.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class MClass  {
    /** Used to store the complement description. */
    private String mDesc;
    /** Used to store the complements list. */
    private ArrayList complements = new ArrayList();
    /** Constructs an empty <tt>MClass</tt> object. */
    public MClass() {
         /**
     * Constructs a <tt> MClass </tt> object with the specified description,
     *  and complements.
     *
     */
    }
    /**
     * Get the description of the morphological Class.
     * @return Cdesc MClass description
     */
    public final String getMdesc() {
        return mDesc;
    }
    /**
     * Set the MClass object description
     * to the specified value given in parameter.
     * @param desc a Strings containing the object description
     */
    public final void setMdesc(final String desc) {
        this.mDesc = desc;
    }
    /**
     * Get the list of the MClass complements.
     * @return the list of the MClass complements
     */
    public final List getComplements() {
        return complements;
    }
    /**
     * add a Complement to the MClass.
     * @param complement a Complement object
     */
    public final void addComplement(final Complement complement) {
        complements.add(complement);
    }
    /**
     * Set the MClass object Complements
     * to the specified value given in parameter.
     * @param letters a Strings containing the Complements
     */
    public final void setComplements(final ArrayList letters) {
        this.complements = letters;
    }
    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return mDesc;
    }
}