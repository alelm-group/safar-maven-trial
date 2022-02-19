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



/**
 * The <tt>SAFARLevenshtein</tt> class is a set of Levenshtein utilities
 * allowing Levenshtein implementations.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY driss
 * @version 1.0
 */
public class SAFARLevenshtein implements ILevenshtein {

    
    /**
     * The getLevenshtein method compute the Levenshtein using
     * the giving parameters.
     * @param lS first string
     * @param rS second string
     * @return the map order/solution
     */
        @Override
    public final int getLevenshtein(CharSequence lS, CharSequence rS) {      
        int len0 = lS.length() + 1;
        int len1 = rS.length() + 1;
        int[] cost = new int[len0];
        int[] newcost = new int[len0];
        for (int i = 0; i < len0; i++) cost[i] = i;
        for (int j = 1; j < len1; j++) {
            newcost[0] = j;
            for(int i = 1; i < len0; i++) {
                int match = (lS.charAt(i - 1) == rS.charAt(j - 1)) ? 0 : 1;
                int cost_replace = cost[i - 1] + match;
                int cost_insert = cost[i] + 1;
                int cost_delete = newcost[i - 1] + 1;
                newcost[i] = Math.min(Math.min(cost_insert, cost_delete),
                        cost_replace);
            }
            int[] swap = cost; cost = newcost; newcost = swap;
        }
        return cost[len0 - 1];
    }
}