package safar.modern_standard_arabic.resources.lexicon.arabic_particles.model;

import java.util.ArrayList;

/**The <tt> Perfect Items </tt> class is used to
 * store a Items object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class Items {
    /** Used to store the Items list. */
    private ArrayList pItems = new ArrayList();
    /** Constructs an empty <tt>Items</tt> object. */
    public Items() {
    /**
     * Constructs a <tt> Items </tt> object.
     *
     */
    }
    /**
     * Returns all Items.
     * @return Items
     */
    public final ArrayList getItems() {
        return pItems;
    }
    /** Set the Items object list
     * to the specified value given in parameter.
     * @param letters a Strings containing the Items object list
     */
    public final void setItems(final ArrayList letters) {
        this.pItems = letters;
    }
    /**
     * add a Item to the Items list.
     * @param letter a Item object
     */
    public final void addItem(final Item letter) {
        pItems.add(letter);
    }
}
