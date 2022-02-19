 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.util.normalization.factory;

import common.constants.Normalizer;
import common.manage_errors.Errors;
import safar.modern_standard_arabic.util.normalization.impl.SAFARNormalizer;
import safar.modern_standard_arabic.util.normalization.interfaces.INormalizer;

/**
 * The <tt>NormalizerFactory</tt> class is used to get instances
 * of normalizers implementations. All normalizers implementations
 * calls must go through methods of this class.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @version 1.0
 */
public abstract class NormalizerFactory {

    /** Used for SAFAR normalizer implementation. */
    private static INormalizer safarNormalizerImpl;

    /**
    * Returns an instance of SAFAR normalizer implementation. If an
    * instance already exists, it will be returned without creating a new one.
    *
    * @return instance of SAFAR normalizer implementation.
    */
    public static INormalizer getSAFARNormalizerImplementation() {
        if (safarNormalizerImpl == null) {
            safarNormalizerImpl = new SAFARNormalizer();
        }
        return safarNormalizerImpl;
    }

    /**
     * Returns an instance of the normalizer specified in parameter.
     * <br>All normalizers names can be found in the
     * <tt>Normalizer</tt> classe.
     * @param normalizer name of the normalizer to be instanciated
     * @return <code>INormalizer</code> implementation
     */
    public static INormalizer getImplementation(final String normalizer) {

        if (normalizer.equals(Normalizer.SAFAR_NORMALIZER)) {
            return getSAFARNormalizerImplementation();
        } else {
            Errors.manageError("Error", "Can not found \""
                    + normalizer + "\" implementation");
            return null;
        }

    }
}
