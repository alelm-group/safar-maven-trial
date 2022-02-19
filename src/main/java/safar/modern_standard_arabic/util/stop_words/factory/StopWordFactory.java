package safar.modern_standard_arabic.util.stop_words.factory;


import safar.modern_standard_arabic.util.stop_words.impl.SWsService;

import safar.modern_standard_arabic.util.stop_words.interfaces.ISWsService;





/**
 * The <tt>StopWordFactory</tt> class is used to get instances
 * of StopWord implementations. All StopWord implementations
 * calls must go through methods of this class.
 *
 * @author BOUZOUBAA Karim
 * @author NAMLY Driss
 * @version 1.0
 */
public abstract class StopWordFactory {

    /** Used for StopWord Service implementation. */
    private static ISWsService sWsImpl;

    /**
    * Returns an instance of Detection Model implementation. If an
    * instance already exists, it will be returned without creating a new one.
    *
    * @return instance of Detection Model implementation.
    */
    public static ISWsService getSWsImplementation() {
        if (sWsImpl == null) {
            sWsImpl = new SWsService();
        }
        return sWsImpl;
    }
}
