 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.machine_learning.levenshtein.impl;



import safar.machine_learning.levenshtein.interfaces.ILevenshtein;
import org.apache.commons.text.similarity.LevenshteinDistance;



/**
 * The <tt>ApacheLevenshtein</tt> class is a set of Levenshtein utilities
 * allowing Apache Levenshtein implementations.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY driss
 * @version 1.0
 */
public class ApacheLevenshtein implements ILevenshtein {

    
    /**
     * The getLevenshtein method compute the Levenshtein using
     * the giving parameters.
     * @param lS first string
     * @param rS second string
     * @return the map order/solution
     */
        @Override
    public final int getLevenshtein(CharSequence lS, CharSequence rS) {
        LevenshteinDistance apacheL = LevenshteinDistance.getDefaultInstance();
        int lev = apacheL.apply(lS, rS);
        return lev;
    }
}