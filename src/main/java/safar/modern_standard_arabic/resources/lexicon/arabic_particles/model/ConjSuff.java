package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;

/**The <tt> ConjSuff </tt> class is used to
 * store one ConjSuff object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/
public class ConjSuff implements java.io.Serializable {
    /** Used to store the Perfect Conjunction Affix class Name. */
    private String className;
    /** Used to store the perfect class Items. */
    private ArrayList<Item> Items = new ArrayList<>();
    /** Constructs an empty <tt>ConjSuff</tt> object. */
    public ConjSuff() {
        /**
     * Constructs a <tt> Perfect Conjunction Affix </tt> object with the
     * specified className and Items.
     *
     */
    }
    /**
     * Returns the list of the ConjSuff SyntClass.
     * @return the list of the ConjSuff SyntClass
     */
    public final ArrayList<Item> getItems() {
        return Items;
    }
    /**
     * Set the ConjSuff object SyntClass
     * to the specified value given in parameter.
     * @param letters a Strings containing the SyntClass
     */
    public final void setItems(final ArrayList<Item> letters) {
        this.Items = letters;
    }
    /**
     * add a Item to the Items list.
     * @param letter a Item object
     */
    public final void addItem(final Item letter) {
        Items.add(letter);
    }
    /**
     * Returns the className of the ConjSuff.
     * @return className of the ConjSuff
     */
    public final String getClassName() {
        return className;
    }
    /** Set the ConjSuff object className
     * to the specified value given in parameter.
     * @param unvoweledf a Strings containing the object className
     */
    public final void setClassName(final String unvoweledf) {
        this.className = unvoweledf;
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public final String toString() {
        return className;
    }
}
