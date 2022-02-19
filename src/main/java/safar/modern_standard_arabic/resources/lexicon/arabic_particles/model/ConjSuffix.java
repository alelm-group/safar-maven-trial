package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;
import java.util.List;
/**The <tt> ConjSuffix </tt> class is used to
 * store a ConjSuffix object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class ConjSuffix {
    /** Used to store the conjSuffix list. */
    private ArrayList conjSuffix = new ArrayList();
    /** Constructs an empty <tt>conjSuffix</tt> object. */
    public ConjSuffix() {
        /**
     * Constructs a <tt> conjSuffix </tt> object.
     *
     */
    }
    /**
     * Returns all conjSuffix.
     * @return conjSuffix
     */
    public final List getConjSuffix() {
        return conjSuffix;
    }
    /** Set the conjSuffix object list
     * to the specified value given in parameter.
     * @param letters a Strings containing the conjSuffix object list
     */
    public final void setConjSuffix(final ArrayList letters) {
        this.conjSuffix = letters;
    }
    /**
     * add a PConjAffixe to the conjSuffix list.
     * @param letter a PConjAffixe object
     */
    public final void addConjSuff(final ConjSuff letter) {
        conjSuffix.add(letter);
    }
}
