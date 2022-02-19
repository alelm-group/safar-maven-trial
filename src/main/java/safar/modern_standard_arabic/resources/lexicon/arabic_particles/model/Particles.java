package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;
import java.util.List;

/**The <tt> Particles </tt> class is used to
 * store a particles object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Particles {
    /** Used to store the particles list. */
    private ArrayList particles = new ArrayList();
    /** Constructs an empty <tt>Particles</tt> object. */
    public Particles() {
    /**
     * Constructs a <tt> Particles </tt> object.
     *
     */
    }
    /**
     * Get all particles.
     * @return particles
     */
    public final List getParticles() {
        return particles;
    }
    /** Set the Particles object list
     * to the specified value given in parameter.
     * @param letters a Strings containing the Particles object list
     */
    public final void setParticles(final ArrayList letters) {
        this.particles = letters;
    }
    /**
     * add a Particle to the Particles list.
     * @param letter a Particle object
     */
    public final void addParticle(final Particle letter) {
        particles.add(letter);
    }
}
