package safar.modern_standard_arabic.resources.lexicon.arabic_particles.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .interfaces
        .INativeParticleService;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Complement;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.MClass;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Particle;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.CParticle;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Particles;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.CParticles;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .util.Configuration;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .util.Constantes;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .util.Utiliaire;

/**
 * The <tt>ParticleService</tt>class is a set of particle usage
 * methods allowing access to particle data.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 * @version 1.0
 */

public class NativeParticleService implements INativeParticleService {
    /** to store Simple Particles data fileName. **/
    private static final String SFILE_NAME = Configuration
        .getProperty(Constantes.DATA_SIMPLE_PARTICLES);
    /** to store Complex Particles data fileName. **/
    private static final String CFILE_NAME = Configuration
        .getProperty(Constantes.DATA_COMPLEX_PARTICLES);
    /** to store Simple Particles object. **/
    private static final  Particles S_PARTICLES;
    /** to store Complex Particles object. **/
    private static final  CParticles C_PARTICLES;
    /** to store Particle object. **/
    private static Particle particle;
    /** to store MClass object. **/
    private static MClass mclass;
    static {
        S_PARTICLES = Utiliaire.parseXMLSimpleParticle(SFILE_NAME);
        C_PARTICLES = Utiliaire.parseXMLComplexParticle(CFILE_NAME);
    }
    /*** get all Simple Particles in data file.
     * @return list of particle objects
     */
    @Override
    public final List<Particle> getSimpleParticles() {
        return S_PARTICLES.getParticles();
    }
    /*** get the Simple Particles of the complex String one.
     * @param theCP the complex particle
     * @return list of particle objects
     */
    @Override
    public final List<Particle> getSimpleParticlesByComplexString(final String
            theCP) {
        List<Particle> lstRes = new ArrayList<>();
        List<CParticle> lstParticles;
        lstParticles = C_PARTICLES.getCParticles();
        for (CParticle myParticle : lstParticles) {
            if (myParticle.getVoweledform().equals(theCP) ||
                    myParticle.getVoweledform().replaceAll("[ًٌٍَُِّْ ]", "")
                            .equals(theCP)) {
                lstRes.addAll(getSimpleParticlesBySimpleString(myParticle
                        .getSimpleParticle()));
            }
        }
        return lstRes;
    }
    /**
     * get simple particle by a specific Simple particle string.
     * @param strForm a Strings containing the particule Form
     * @return list of SimpleParticles objects
     */
    @Override
    public final List<Particle> getSimpleParticlesBySimpleString(final String
            strForm) {
        List<Particle> particl = new ArrayList<>();
        List<Particle> lstparticles = new ArrayList<>();
        if (S_PARTICLES != null) {
            lstparticles = S_PARTICLES.getParticles();
        }
        Iterator<Particle> it = lstparticles.iterator();
        while (it.hasNext()) {
            Particle myParticle = it.next();
            if (myParticle.getUnvoweledform().equals(strForm) ||
                    myParticle.getVoweledform().equals(strForm)) {
                particl.add(myParticle);
            }
        }
        return particl;
    }
    /**
     * get simple particle by a specific particle string.
     * @param strForm a Strings containing the particule Form
     * @return list of SimpleParticles objects
     */
    @Override
    public final List<Particle> getSimpleParticlesByString(final String
            strForm) {
        List<Particle> particl = new ArrayList<>();
        particl.addAll(getSimpleParticlesBySimpleString(strForm));
        particl.addAll(getSimpleParticlesByComplexString(strForm));
        return particl;
    }
    /*** get the complex Particles of the Simple one.
     * @param theSP the simple particle
     * @return list of cparticle objects
     */
    @Override
    public final List<CParticle> getComplexParticlesBySimpleString(final String
            theSP) {
        List<CParticle> lstRes = new ArrayList<>();
        List<CParticle> lstParticles;
        lstParticles = C_PARTICLES.getCParticles();
        for (CParticle myParticle : lstParticles) {
            if (myParticle.getSimpleParticle().equals(theSP) ||
                    myParticle.getSimpleParticle().replaceAll("[ًٌٍَُِّْ ]", "")
                            .equals(theSP)) {
                lstRes.add(myParticle);
            }
        }
        return lstRes;
    }
    /*** get all Complex Particles in data file.
     * @return list of particle objects
     */
    @Override
    public final List<CParticle> getComplexParticles() {
        return C_PARTICLES.getCParticles();
    }
    /*** get particle MClasses.
     * @return list of MClass objects
     */
    @Override
    public final List<MClass> getMClasses() {
        return particle.getMClasses();
    }
    /*** get mclass Complements.
     * @return list of Complement objects
     */
    @Override
    public final List<Complement> getComplements() {
        return mclass.getComplements();
    }
    /**
     * get Complements of a specific mclass.
     * @param theMclass a Strings containing the MClass
     * @return list of Complement objects
     */
    @Override
    public final List<Complement> getComplements(final String theMclass) {
        List<Complement> lstRes = new ArrayList<>();
        List<MClass> lstMClasses;
        List<Particle> lstParticles;
        lstParticles = S_PARTICLES.getParticles();
        for (Particle myParticle : lstParticles) {
            lstMClasses = myParticle.getMClasses();
            for (MClass myMClass : lstMClasses) {
                String res = myMClass.getMdesc();
                if (res.contains(theMclass)) {
                    lstRes = myMClass.getComplements();
                }
            }
        }
        return lstRes;
    }
    /**
     * get MClasses of a specific particle.
     * @param theParticle a Strings containing the particle
     * @return list of MClass objects
     */
    @Override
    public final List<MClass> getMClasses(final String theParticle) {
        List<MClass> lstRes = new ArrayList<>();
        List<Particle> lstparticles;
        lstparticles = S_PARTICLES.getParticles();
        for (Particle myParticle : lstparticles) {
            if (myParticle.getVoweledform().equals(theParticle)
                    || myParticle.getUnvoweledform().equals(theParticle)) {
                lstRes = myParticle.getMClasses();
            }
        }
        return lstRes;
    }
    
    /**
     * get all particles containing an MClass with the specific mdesc.
     * @param mDesc a Strings containing desciption of the morphological class
     * @return list of particle String
     */
    @Override
    public final List<String> getParticleByMClass(final String mDesc) {
        List<String> lstRes = new ArrayList<>();
        List<MClass> lstmclasses;
        List<Particle> lstparticles;
        String particulDesc;
        lstparticles = S_PARTICLES.getParticles();
        for (Particle myParticle : lstparticles) {
            lstmclasses = myParticle.getMClasses();
            particulDesc = myParticle.getUnvoweledform();
            for (MClass myMClass : lstmclasses) {
                String res = myMClass.getMdesc();
                if (res.contains(mDesc)) {
                    lstRes.add(particulDesc);
                }
            }
        }
        return lstRes;
    }
    /***test if an unvoweled Form exist
     * in simple particles data (if it's a simple particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    @Override
    public final boolean  isSParticle(final String unvoweledForm) {
        boolean find = false;
        List<Particle> lstparticles = new ArrayList<>();
        if (S_PARTICLES != null) {
            lstparticles = S_PARTICLES.getParticles();
        }
        Iterator<Particle> it = lstparticles.iterator();
        while (it.hasNext() && !find) {
            Particle myParticle = it.next();
            if (((myParticle.getUnvoweledform()
                    .equals(unvoweledForm)))
                    || (myParticle.getVoweledform()
                            .equals(unvoweledForm))) {
                find = true;
            }
        }
        return find;
    }
    /***test if an unvoweled Form exist
     * in complex particles data (if it's a complex particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    @Override
    public final boolean  isCParticle(final String unvoweledForm) {
        boolean find = false;
        List<CParticle> lstparticles = new ArrayList<>();
        if (C_PARTICLES != null) {
            lstparticles = C_PARTICLES.getCParticles();
        }
        Iterator<CParticle> it = lstparticles.iterator();
        while (it.hasNext() && !find) {
            CParticle myParticle = it.next();
            if (((myParticle.getVoweledform().replaceAll("[ًٌٍَُِّْ ]", "")
                    .equals(unvoweledForm)))
                    || (myParticle.getVoweledform()
                            .equals(unvoweledForm))) {
                find = true;
            }
        }
        return find;
    }
    /***test if an unvoweled Form exist
     * in particles data (if it's a particle ).
     * @param unvoweledForm a Strings containing the
     * unvoweled Form of an particle
     * @return boolean it is or it isn't
     */
    @Override
    public final boolean  isParticle(final String unvoweledForm) {
        boolean find = false;
        if (isCParticle(unvoweledForm) || isSParticle(unvoweledForm)) {
            find = true;
        }
        return find;
    }
}