package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;

/**The <tt> Perfect PersonalPronouns </tt> class is used to
 * store a PersonalPronouns object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class PersonalPronouns {
    /** Used to store the PersonalPronouns list. */
    private ArrayList PersonalPronouns = new ArrayList();
    /** Constructs an empty <tt>PersonalPronouns</tt> object. */
    public PersonalPronouns() {
    /**
     * Constructs a <tt> PersonalPronouns </tt> object.
     *
     */
    }
    /**
     * Returns all PersonalPronouns.
     * @return PersonalPronouns
     */
    public final ArrayList getPersonalPronouns() {
        return PersonalPronouns;
    }
    /** Set the PersonalPronouns object list
     * to the specified value given in parameter.
     * @param letters a Strings containing the PersonalPronouns object list
     */
    public final void setPersonalPronouns(final ArrayList letters) {
        this.PersonalPronouns = letters;
    }
    /**
     * add a PersonalPronoun to the PersonalPronouns list.
     * @param letter a PersonalPronoun object
     */
    public final void addPersonalPronoun(final PP letter) {
        PersonalPronouns.add(letter);
    }
}
