 /* SAFAR Platform.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.basic.morphology.stemmer.factory;

import common.constants.Stemmer;
import common.manage_errors.Errors;
import safar.modern_standard_arabic.basic.morphology.stemmer.impl
        .Light10Stemmer;

import safar.modern_standard_arabic.basic.morphology.stemmer.interfaces
        .IStemmer;

/**
 * The <tt>StemmerFactory</tt> class is used to get instances of stemmers
 * implementations. All stemmers implementations calls must go through methods
 * of this class.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author SOUTEH Younes
 * @version 1.0
 * @see IStemmer
 * @see Light10Stemmer
 */
public abstract class StemmerFactory {



    /** Used for Light10 Stemmer implementation. */
    private static IStemmer light10Impl;


    /**
    * Returns a new instance of Light10 stemmer implementation. If an instance
    * already exists, it will be returned without creating new one.
    *
    * @return instance of Light10 stemmer implementation.
    */
    public static IStemmer getLight10Implementation() {
        if (light10Impl == null) {
            light10Impl = new Light10Stemmer();
        }
        return light10Impl;
    }




    /**
     * Returns an instance of the stemmer specified in parameter.
     * <br>All stemmers names can be found in the
     * <tt>Stemmers_implementations.properties</tt> file.
     * @param stemmer name of the stemmer to be instanciated
     * @return <code>IStemmer</code> implementation
     */
    public static IStemmer getImplementation(
            final String stemmer) {
        if (stemmer.equals(Stemmer.LIGHT10_STEMMER)) {
            return getLight10Implementation();
        }  else {
            Errors.manageError("Error", "Can not found \""
                    + stemmer + "\" implementation");
            return null;
        }
    }

}
