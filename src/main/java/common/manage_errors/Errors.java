 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more informations see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package common.manage_errors;

/**
 * The <tt>Errors</tt> class is used to manage errors that occured when
 * excecuting tasks.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @version 1.0
 */
public abstract class Errors {

    /**
     * Performs an operation according to the type of error and the message
     * received in parameters.
     * @param errorType error type
     * @param message error message
     */
    public static void manageError(final String errorType,
            final String message) {

            System.out.println(message);

    }

}
