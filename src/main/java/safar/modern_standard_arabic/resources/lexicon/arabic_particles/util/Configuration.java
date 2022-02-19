package safar.modern_standard_arabic.resources.lexicon.arabic_particles.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**The <tt>Configuration</tt>class containing config file loader.
*
* @author BOUZOUBAA Karim
* @author NAMLY Driss
*/
public abstract class Configuration {
    /** to store package Properties object. **/
    private static final Properties PROPERTIES = new Properties();
    /** to store package string Properties. **/
    private static final String CONFIG_PROPERTIES = "safar/"
            + "modern_standard_arabic/resources/lexicon"
            + "/arabic_particles/config/config.properties";
    static {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            java.io.InputStream is = cl.getResourceAsStream(CONFIG_PROPERTIES);
            PROPERTIES.load(is);
            is.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**  get Property of the PROPERTIES object.
     * @param key a Strings containing the PROPERTIES key
     * @return key Property
     */
    public static String getProperty(final String key) {
        return PROPERTIES.getProperty(key);
    }

    /** the main function print the particles data file path.
     *
     * @param args argument
     */
    public static void main(final String[] args) {
        System.out.println(getProperty(Constantes.DATA_COMPLEX_SPECIAL_NOUNS));
    }
}
