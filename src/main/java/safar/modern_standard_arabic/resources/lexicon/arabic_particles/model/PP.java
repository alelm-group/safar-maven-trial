package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;



/**The <tt> Personal Pronoun MorphPptes </tt> class is used to
 * store one Personal Pronoun morphological properties Class.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class PP  {
    /** Used to store the Personal Pronoun id. */
    private String pPid;
    /** Used to store the Personal Pronoun description. */
    private String description;
    /** Used to store the Personal Pronoun gender. */
    private String gender;
    /** Used to store the Personal Pronoun number. */
    private String number;
    /** Used to store the Personal Pronoun person. */
    private String person;
    /** Used to store the Personal Pronoun prefix. */
    private String prefix;
/** Constructs an empty <tt>Personal Pronoun</tt> object. */
    public PP() {
         /**
     * Constructs a <tt> PPMorphPptes </tt> object with the specified
     * description and complements.
     *
     */
    }
    /**
     * Returns the id of the Personal Pronoun.
     * @return Personal Pronoun id
     */
    public final String getPPid() {
        return pPid;
    }
/**
     * Set the Personal Pronoun object id
     * to the specified value given in parameter.
     * @param id a Strings containing the object id
     */
    public final void setPPid(final String id) {
        this.pPid = id;
    }
    /**
     * Returns the description of the Personal Pronoun.
     * @return Personal Pronoun description
     */
    public final String getDescription() {
        return description;
    }
/**
     * Set the Personal Pronoun object description
     * to the specified value given in parameter.
     * @param des a Strings containing the object description
     */
    public final void setDescription(final String des) {
        this.description = des;
    }
    /**
     * Returns the Gender of the Personal Pronoun.
     * @return gender Personal Pronoun Gender
     */
    public final String getGender() {
        return gender;
    }
/**
     * Set the Personal Pronoun object gender
     * to the specified value given in parameter.
     * @param gend a Strings containing the object gender
     */
    public final void setGender(final String gend) {
        this.gender = gend;
    }
 /**
     * Returns the  number of the Personal Pronoun.
     * @return num Personal Pronoun number
     */
    public final String getNumber() {
        return number;
    }
    /**
     * Set the Personal Pronoun object number
     * to the specified value given in parameter.
     * @param num a Strings containing the object number
     */
    public final void setNumber(final String num) {
        this.number = num;
    }
    /**
     * Returns the person of the Personal Pronoun.
     * @return person Personal Pronoun person
     */
    public final String getPerson() {
        return person;
    }
    /**
     * Set the Personal Pronoun object person
     * to the specified value given in parameter.
     * @param per a Strings containing the object person
     */
    public final void setPerson(final String per) {
        this.person = per;
    }
    /**
     * Returns the prefix of the Personal Pronoun.
     * @return Personal Pronoun prefix
     */
    public final String getPrefix() {
        return prefix;
    }
    /**
     * Set the Personal Pronoun object prefix
     * to the specified value given in parameter.
     * @param pr a Strings containing the object prefix
     */
    public final void setPrefix(final String pr) {
        this.prefix = pr;
    }
    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return  pPid + " ; " + description + " ; " + gender + " ; " + number
                + " ; " + person + " ; " + prefix;
    }
}