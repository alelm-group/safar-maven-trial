package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

/**The <tt>Referenced</tt>class is used to store one signalNoun referenced.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Referenced implements java.io.Serializable {
    /** Used to store the referenced gender. */
    private String gender;
    /** Used to store the referenced gender number. */
    private String number;
    /** Constructs an empty <tt>Referenced</tt> object. */
    public Referenced() {

        /**
     * Constructs a <tt>Referenced</tt> object with the specified
     * gender and numerence.
     *
     */
    }

    /**
     * Returns the Gender of the Referenced.
     * @return Gender; Referenced Gender
     */
    public final String getGender() {
        return gender;
    }
/**
     * Set the Referenced object gender
     * to the specified value given in parameter.
     * @param gend a Strings containing the object gender
     */
    public final void setGender(final String gend) {
        this.gender = gend;
    }
 /**
     * Returns the gender numerence of the Referenced.
     * @return num; Referenced gender numerence
     */
    public final String getNumber() {
        return number;
    }
    /**
     * Set the Referenced object numerence
     * to the specified value given in parameter.
     * @param num a Strings containing the object numerence
     */
    public final void setNumber(final String num) {
        this.number = num;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return  gender + " ; " + number;
    }
}