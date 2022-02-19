package safar.modern_standard_arabic.resources.lexicon.arabic_particles.interfaces;

import java.util.List;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Complement;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.MClass;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Particle;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.CParticle;
/**
 * The <tt>IParticleService</tt> interface is used
 * to describe the minimum structure
 * that a particle should have to be valid implementations.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 */
public interface INativeParticleService {
    /*** get all Simple Particles in data file.
        * @return list of particle objects
        */
    List<Particle> getSimpleParticles();
    /*** get the Simple Particles of the complex one.
     * @param theCP the complex particle
     * @return list of particle objects
     */
    List<Particle> getSimpleParticlesByComplexString(final String theCP);
    /**
     * get  simple particles by a specific particle string.
     * @param unvoweledForm a Strings containing the particule unvoweled Form
     * @return list of SimpleParticles objects
     */
    List<Particle> getSimpleParticlesBySimpleString(String unvoweledForm);
    /**
     * get simple particle by a specific particle string.
     * @param strForm a Strings containing the particule Form
     * @return list of SimpleParticles objects
     */
    List<Particle> getSimpleParticlesByString(final String strForm);
    
    /*** get the complex Particles of the Simple one.
     * @param theSP the simple particle
     * @return list of cparticle objects
     */
    List<CParticle> getComplexParticlesBySimpleString(final String theSP);
    /*** get all Complex Particles in data file.
        * @return list of particle objects
        */
    List<CParticle> getComplexParticles();
    /*** get particle MClasses.
         * @return list of MClass objects
         */
    List<MClass> getMClasses();
     /*** get mclass Complements.
         * @return list of Complement objects
         */
    List<Complement> getComplements();
    /**
     * get MClasses of a specific particle.
     * @param theParticle a Strings containing the particle
     * @return list of MClass objects
     */
    List<MClass> getMClasses(String theParticle);
    /**
     * get Complements of a specific mclass.
     * @param theMclass a Strings containing the MClass
     * @return list of Complement objects
     */
    List<Complement> getComplements(String theMclass);
    
    /**
     * get all particles containing an MClass with the specific mdesc.
     * @param mDesc a Strings containing desciption of the morphological class
     * @return list of particle String
     */
    List<String> getParticleByMClass(String mDesc);
    /***test if an unvoweled Form exist
     * in simple particles data (if it's a simple particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    boolean isSParticle(String unvoweledForm);
    /***test if an unvoweled Form exist
     * in complex particles data (if it's a complex particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    boolean isCParticle(String unvoweledForm);
    /***test if an unvoweled Form exist
     * in particles data (if it's a particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    boolean isParticle(String unvoweledForm);
}