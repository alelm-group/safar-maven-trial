 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */
package safar.modern_standard_arabic.util.stop_words.interfaces;

import java.util.List;


/**
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 * @version 1.0
 */
public interface ISWsService {
    /***test if an unvoweled Form exist
     * in sws data (if it's a SW ).
     * @param sw a Strings containing the SW
     * @return boolean it is or it isn't
     */
    boolean  isStopWord(String sw);
}
