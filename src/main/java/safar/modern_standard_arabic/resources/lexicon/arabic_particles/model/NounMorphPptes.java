package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

/**The <tt>MorphPptes</tt>class is used to store one morphPptes object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class NounMorphPptes implements java.io.Serializable {
    /** Used to store the morphPptes gender. */
    private String gender;
    /** Used to store the morphPptes Person. */
    private String person;
    /** Used to store the morphPptes morhpoSyntCas. */
    private String morhpoSyntCas;
    /** Used to store the morphPptes gender number. */
    private String number;
    /** Constructs an empty <tt>MorphPptes</tt> object. */
    public NounMorphPptes() {

        /**
     * Constructs a <tt>MorphPptes</tt> object with the specified
     * gender and numerence.
     *
     */
    }

    /**
     * Returns the getPerson of the MorphPptes.
     * @return getPerson; MorphPptes getPerson
     */
    public final String getPerson() {
        return person;
    }
/**
     * Set the MorphPptes object getPerson
     * to the specified value given in parameter.
     * @param pers a Strings containing the object getPerson
     */
    public final void setPerson(final String pers) {
        this.person = pers;
    }
    /**
     * Returns the Gender of the MorphPptes.
     * @return Gender; MorphPptes Gender
     */
    public final String getGender() {
        return gender;
    }
    /**
     * Set the MorphPptes object gender
     * to the specified value given in parameter.
     * @param gend a Strings containing the object gender
     */
    public final void setGender(final String gend) {
        this.gender = gend;
    }
    /**
     * Returns the Number  of the MorphPptes.
     * @return num; MorphPptes Number
     */
    public final String getNumber() {
        return number;
    }
    /**
     * Set the MorphPptes object Number
     * to the specified value given in parameter.
     * @param num a Strings containing the object Number
     */
    public final void setNumber(final String num) {
        this.number = num;
    }
    /** Set the MorphPptes object MorhpoSyntCas
     * to the specified value given in parameter.
     * @param cas a Strings containing the object MorhpoSyntCas
     */
    public final void setMorhpoSyntCas(final String cas) {
        this.morhpoSyntCas = cas;
    }
    /**
     * Returns the MorhpoSyntCas of the MorphPptes.
     * @return MorhpoSyntCas of the MorphPptes
     */
    public final String getMorhpoSyntCas() {
        return morhpoSyntCas;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return  gender + " ; " + number + " ; "
                + person + " ; " + morhpoSyntCas;
    }
}