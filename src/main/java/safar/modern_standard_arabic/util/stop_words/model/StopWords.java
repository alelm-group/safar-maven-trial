package safar.modern_standard_arabic.util.stop_words.model;

import java.util.ArrayList;
import java.util.List;

/**The <tt> StopWords </tt> class is used to
 * store a StopWords object.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
*/

public class StopWords {
    /** Used to store the StopWords list. */
    private ArrayList<StopWord> stopWords = new ArrayList();
    /** Constructs an empty <tt>StopWords</tt> object. */
    public StopWords() {
    /**
     * Constructs a <tt> StopWords </tt> object.
     *
     */
    }
    /**
     * Get all StopWords.
     * @return StopWords
     */
    public final List<StopWord> getStopWords() {
        return stopWords;
    }
    /** Set the StopWords object list
     * to the specified value given in parameter.
     * @param sws a Strings containing the StopWords object list
     */
    public final void setStopWords(final ArrayList<StopWord> sws) {
        this.stopWords = sws;
    }
    /**
     * add a StopWord to the StopWords list.
     * @param letter a StopWord object
     */
    public final void addStopWord(final StopWord letter) {
        stopWords.add(letter);
    }
}
