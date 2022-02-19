/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.factory;

import safar.modern_standard_arabic.basic.syntax.posTagger.impl.SafarLightPOS;
import safar.modern_standard_arabic.basic.syntax.posTagger.interfaces.IPos;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The <tt>PosFactory</tt> class is used to get instances
 * of POS taggers implementations. All POS Taggers implementations
 * calls must go through methods of this class.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class PosFactory {

    /** Used for Safar Light POS implementation. */
    private static IPos safarLightPOSImplementation;
    /**
     * Constructs a PosFactory object.
     */
    public PosFactory() {
    }
    /**
     * Returns a new instance of Safar Ligth POS Tagger implementation.
     * @return safarLightPOSImplementation.
     */
    public static IPos getSafarLightPOSImplementation() {
        if (safarLightPOSImplementation == null) {
            safarLightPOSImplementation = new SafarLightPOS();
        }
        return safarLightPOSImplementation;
    }
}
