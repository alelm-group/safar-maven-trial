package safar.machine_learning.levenshtein.interfaces;




/**
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY driss
 * @version 1.0
 */
public interface ILevenshtein {
    /**
     * The getLevenshtein method compute the Levenshtein using
     * the giving parameters.
     * @param lS first string
     * @param rS second string
     * @return the map order/solution
     */
    int getLevenshtein(CharSequence lS, CharSequence rS);
}
