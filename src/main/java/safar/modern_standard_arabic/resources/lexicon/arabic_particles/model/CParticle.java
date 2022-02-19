package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;



/**The <tt> ComplexParticle </tt> class is used to
 * store one complexParticle object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class CParticle {
    /** Used to store the ComplexParticle voweledform. */
    private String voweledform;
    /** Used to store the ComplexParticle prefix. */
    private String pref;
    /** Used to store the ComplexParticle simple Particle. */
    private String simpleP;
    /** Used to store the ComplexParticle suffix. */
    private String suff;
    /** Constructs an empty <tt>ComplexParticle</tt> object. */
    public CParticle() {
    /**
     * Constructs a <tt> ComplexParticle </tt> object with the specified voweled,
     * prefix, simple Particle and suffix.
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
     * @return the simpleP
     */
    public final String getSimpleParticle() {
        return simpleP;
    }

    /**
     * @param sP the simpleParticle to set
     */
    public final void setSimpleParticle(final String sP) {
        this.simpleP = sP;
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
        return voweledform + " " + pref + " " + simpleP + " " + suff;
    }
}