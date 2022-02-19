package safar.modern_standard_arabic.resources.lexicon.arabic_particles.factory;

import safar.modern_standard_arabic.resources.lexicon.arabic_particles.impl
        .NativeParticleService;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .interfaces.INativeParticleService;


/**
 * The <tt>ParticleFactory</tt> class is used to get instances
 * of Particle implementations. All Particle implementations
 * calls must go through methods of this class.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 * @version 1.0
 * @see INativeParticleService
 * @see NativeParticleService
 */
public abstract class NativeParticleFactory {

    /** Used for Particle Service implementation. */
    private static INativeParticleService particleImpl;

    /**
    * Returns an instance of Particle implementation. If an
    * instance already exists, it will be returned without creating a new one.
    *
    * @return instance of Particle implementation.
    */
    public static INativeParticleService getParticleImplementation() {
        if (particleImpl == null) {
            particleImpl = new NativeParticleService();
        }
        return particleImpl;
    }
}
