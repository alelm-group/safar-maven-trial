package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;
import java.util.List;

/**The <tt> Particles </tt> class is used to
 * store a particles object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class CParticles {
    /** Used to store the particles list. */
    private ArrayList cParticles = new ArrayList();
    /** Constructs an empty <tt>Complex Particles</tt> object. */
    public CParticles() {
    /**
     * Constructs a <tt> Complex Particles </tt> object.
     *
     */
    }
    /**
     * Get all Complex particles.
     * @return Complex particles
     */
    public final List getCParticles() {
        return cParticles;
    }
    /** Set the Complex Particles object list
     * to the specified value given in parameter.
     * @param letters a Strings containing the Complex Particles object list
     */
    public final void setCParticles(final ArrayList letters) {
        this.cParticles = letters;
    }
    /**
     * add a Complex Particle to the Complex Particles list.
     * @param letter a Complex Particle object
     */
    public final void addCParticle(final CParticle letter) {
        cParticles.add(letter);
    }
}
