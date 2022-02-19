 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */
package safar.modern_standard_arabic.util.stop_words.impl;



import safar.modern_standard_arabic.util.stop_words.interfaces.ISWsService;
import safar.modern_standard_arabic.util.stop_words.model.StopWord;
import safar.modern_standard_arabic.util.stop_words.model.StopWords;
import safar.modern_standard_arabic.util.stop_words.util.Configuration;
import safar.modern_standard_arabic.util.stop_words.util.Constantes;
import safar.modern_standard_arabic.util.stop_words.util.Utilitaire;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


 /**
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 * @version 1.0
 */
public class SWsService implements ISWsService {
     private static final String FILE_NAME = Configuration
             .getProperty(Constantes.DATA_SW);
     /** to store Stop-Words object. **/
     private static final StopWords SWS;

     static {
         SWS = Utilitaire.parseXMLSW(FILE_NAME);
     }


    /***test if an unvoweled Form exist
     * in sws data (if it's a SW ).
     * @param sw a Strings containing the SW
     * @return boolean it is or it isn't
     */

    @Override
    public final boolean  isStopWord(final String sw) {
        return isDomainIndependentSW(sw);
    }

     public final boolean  isDomainIndependentSW(final String sw) {
         boolean find = false;
         List<StopWord> lstSWs = new ArrayList<>();
         if (SWS != null) {
             lstSWs = SWS.getStopWords();
         }
         Iterator<StopWord> it = lstSWs.iterator();
         while (it.hasNext() && !find) {
             StopWord mySW = it.next();
             String unvSW = mySW.getUnvoweledform();
             String vSW = mySW.getVoweledform();
             if ((vSW.equals(sw)) || (unvSW.equals(sw))) {
                 find = true;
             }
         }
         return find;
     }
}
