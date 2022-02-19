package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

/**The <tt>Complement</tt>class is used to store one particle complement.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Complement implements java.io.Serializable {
    /** Used to store the complement description. */
    private String cDesc;
    /** Used to store the complement syntaxic proprerties. */
    private String sprop;
    /** Used to store the complement sample. */
    private String sample;
    /** Used to store the complement sample reference. */
    private String ref;
    
    /** Constructs an empty <tt>Complement</tt> object. */
    public Complement() {

        /**
     * Constructs a <tt>Complement</tt> object with the specified description,
     * sample and reference.
     *
     */
    }

      /**
     * Get the description of the Complement.
     * @return Cdesc Complement description
     */
    public final String getCdesc() {
        return cDesc;
    }

    /**
     * Set the Complement object description
     * to the specified value given in parameter.
     * @param cdes a Strings containing the object description
     */
    public final void setCdesc(final String cdes) {
        this.cDesc = cdes;
    }
/**
     * Get the description of the syntaxic proprerties.
     * @return sprop Complement syntaxic proprerties
     */
    public final String getSprop() {
        return sprop;
    }

    /**
     * Set the Complement object syntaxic proprerties
     * to the specified value given in parameter.
     * @param sp a Strings containing the object syntaxic proprerties
     */
    public final void setSprop(final String sp) {
        this.sprop = sp;
    }
    /**
     * Get the Sample of the Complement.
     * @return Sample; Complement Sample
     */
    public final String getSample() {
        return sample;
    }
/**
     * Set the Complement object sample
     * to the specified value given in parameter.
     * @param sampl a Strings containing the object sample
     */
    public final void setSample(final String sampl) {
        this.sample = sampl;
    }
 /**
     * Get the sample reference of the Complement.
     * @return ref; Complement sample reference
     */
    public final String getRef() {
        return ref;
    }
    /**
     * Set the Complement object exemple reference
     * to the specified value given in parameter.
     * @param refe a Strings containing the object reference
     */
    public final void setRef(final String refe) {
        this.ref = refe;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return cDesc + " : " + sprop + " : " + sample + " ; " + ref;
    }
}