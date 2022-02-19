package safar.modern_standard_arabic.resources.lexicon.arabic_particles.util;

import java.io.IOException;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Particle;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Particles;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.CParticle;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.CParticles;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.Complement;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles
        .model.MClass;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles.model
        .ConjSuff;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles.model
        .ConjSuffix;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles.model
        .Item;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles.model
        .PersonalPronouns;
import safar.modern_standard_arabic.resources.lexicon.arabic_particles.model
        .PP;



/**The <tt>Utiliaire</tt>class containing xml parser.
*
* @author BOUZOUBAA Karim
* @author NAMLY Driss
*/
public abstract class Utiliaire {

    /*** Simple Particles XML parser.
     * @param fileName a Strings containing the file Name
     * @return particles
     */

    public static Particles parseXMLSimpleParticle(final String fileName) {
        Particles particles = null;
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
            /*
            *start load
            */
            digester.addObjectCreate("arabic_particles", Particles.class);
            digester.addObjectCreate("arabic_particles/particle",
                    Particle.class);
            digester.addBeanPropertySetter("arabic_particles/particle"
                    + "/Form/voweledform", "voweledform");
            digester.addBeanPropertySetter("arabic_particles/particle"
                    + "/Form/unvoweledform", "unvoweledform");
            digester.addObjectCreate("arabic_particles/particle/MClasses"
                    + "/MClass", MClass.class);
            digester.addBeanPropertySetter("arabic_particles/particle/MClasses"
                    + "/MClass/Mdesc", "mdesc");
            digester.addObjectCreate("arabic_particles/particle/MClasses/MClass"
                    + "/complements/complement", Complement.class);
            digester.addBeanPropertySetter("arabic_particles/particle/MClasses"
                    + "/MClass/complements/complement/Cdesc", "cdesc");
            digester.addBeanPropertySetter("arabic_particles/particle/MClasses"
                    + "/MClass/complements/complement/Sprop", "sprop");
            digester.addBeanPropertySetter("arabic_particles/particle/MClasses"
                    + "/MClasscomplements/complement/sample", "sample");
            digester.addBeanPropertySetter("arabic_particles/particle/MClasses"
                    + "/MClass/complements/complement/ref", "ref");
            digester.addSetNext("arabic_particles/particle/MClasses/MClass"
                    + "/complements/complement", "addComplement");
            digester.addSetNext("arabic_particles/particle/MClasses/MClass"
                    + "", "addMClass");
            digester.addSetNext("arabic_particles/particle", "addParticle");

            /* end load letters */

            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(fileName);
            particles = (Particles) digester.parse(is);

        } catch (IOException | SAXException exc) {
        }
        return particles;
    }
    
    /*** Complex Particles XML parser.
     * @param fileName a Strings containing the file Name
     * @return particles
     */

    public static CParticles parseXMLComplexParticle(final String fileName) {
        CParticles particles = null;
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
            /*
            *start load
            */
            digester.addObjectCreate("ComplexParticles", CParticles.class);
            digester.addObjectCreate("ComplexParticles/CPar",
                    CParticle.class);
            digester.addBeanPropertySetter("ComplexParticles/CPar"
                    + "/vow", "voweledform");
            digester.addBeanPropertySetter("ComplexParticles/CPar"
                    + "/P", "pref");
            digester.addBeanPropertySetter("ComplexParticles/CPar"
                    + "/SP", "simpleParticle");
            digester.addBeanPropertySetter("ComplexParticles/CPar"
                    + "/S", "suff");
            digester.addSetNext("ComplexParticles/CPar", "addCParticle");

            /* end load */

            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(fileName);
            particles = (CParticles) digester.parse(is);

        } catch (IOException | SAXException exc) {
        }
        return particles;
    }
	



    public static ConjSuffix parseXMLConjSuffixes(
            final String fileName) {
        ConjSuffix conjSuffix = null;
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
           /*
            * start load letters
            */
            digester.addObjectCreate("ConjSuffixes", ConjSuffix.class);
            digester.addObjectCreate("ConjSuffixes/ConjSuffix", ConjSuff.class);
            digester.addBeanPropertySetter("ConjSuffixes/ConjSuffix"
                    + "/className", "className");
            digester.addObjectCreate("ConjSuffixes/ConjSuffix/Items/Item",
                    Item.class);
            digester.addSetProperties("ConjSuffixes/ConjSuffix/Items/Item",
                    "id", "PPId");
            digester.addSetProperties("ConjSuffixes/ConjSuffix/Items/Item",
                    "unv", "unvoweledform");
            digester.addSetProperties("ConjSuffixes/ConjSuffix/Items/Item",
                    "vow", "voweledform");

            digester.addSetNext("ConjSuffixes/ConjSuffix/Items/Item",
                    "addItem");
            digester.addSetNext("ConjSuffixes/ConjSuffix", "addConjSuff");


            /* end load letters */
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(fileName);
            conjSuffix = (ConjSuffix) digester.parse(is);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return conjSuffix;
    }
    /*** personalPronouns XML parser.
     * @param fileName a Strings containing the file Name
     * @return PerfectConjAffixes
     */

    public static PersonalPronouns parseXMLPersonalPronouns(
            final String fileName) {
        PersonalPronouns pPs = null;
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
           /*
            * start load letters
            */

            digester.addObjectCreate("personalPronouns",
                    PersonalPronouns.class);
            digester.addObjectCreate("personalPronouns/pp",
                    PP.class);
            digester.addSetProperties("personalPronouns/pp", "id", "PPid");
            digester.addSetProperties("personalPronouns/pp",
                    "des", "description");
            digester.addSetProperties("personalPronouns/pp", "gen", "gender");
            digester.addSetProperties("personalPronouns/pp", "num", "number");
            digester.addSetProperties("personalPronouns/pp", "per", "person");
            digester.addSetProperties("personalPronouns/pp", "pf", "prefix");
            digester.addSetNext("personalPronouns/pp", "addPersonalPronoun");


            /* end load letters */
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(fileName);
            pPs = (PersonalPronouns) digester.parse(is);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return pPs;
    }
}
