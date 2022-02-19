 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.machine_learning.levenshtein.factory;

import safar.machine_learning.levenshtein.impl.SAFARLevenshtein;
import safar.machine_learning.levenshtein.impl.ApacheLevenshtein;
import safar.machine_learning.levenshtein.interfaces.ILevenshtein;



/**
 * The <tt>LevenshteinFactory</tt> class is used to get instances
 * of Levenshtein distance implementations. All Levenshtein implementations
 * calls must go through methods of this class.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY driss
 * @version 1.0
 */
public abstract class LevenshteinFactory {

    /** Used for SAFAR Levenshtein implementation. */
    private static ILevenshtein SafarILevenshtein;
    
    /** Used for Apache Levenshtein implementation. */
    private static ILevenshtein ApacheILevenshtein;

    /**
    * Returns an instance of SAFAR Levenshtein implementation. If an
    * instance already exists, it will be returned without creating a new one.
    *
    * @return instance of SAFAR Levenshtein implementation.
    */
    public static ILevenshtein getSAFARImplementation() {
        if (SafarILevenshtein == null) {
            SafarILevenshtein = new SAFARLevenshtein();
        }
        return SafarILevenshtein;
    }
    
    /**
    * Returns an instance of Apache Levenshtein implementation. If an
    * instance already exists, it will be returned without creating a new one.
    *
    * @return instance of Apache Levenshtein implementation.
    */
    public static ILevenshtein getApacheImplementation() {
        if (ApacheILevenshtein == null) {
            ApacheILevenshtein = new ApacheLevenshtein();
        }
        return ApacheILevenshtein;
    }
}
