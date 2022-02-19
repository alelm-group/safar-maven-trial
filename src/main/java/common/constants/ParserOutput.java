 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more informations see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */
package common.constants;

/**
 * The <code>Parser</code> class is used to store constants that concerne
 * syntax parsers output types.
 *
 * @author JAAFAR Younes
 * @author BOUZOUBAA Karim
 * @version 1.0
 */
public abstract class ParserOutput {

    /** Get parser results as simple tree. */
    public static final String SIMPLE_TREE = "SIMPLE_TREE";

    /** Get parser results as XML tree. */
    public static final String XML_TREE = "XML_TREE";

    /** Get parser results as simple tree with dependencies. */
    public static final String XML_TREE_WITH_DEPENDENCIES =
            "XML_TREE_WITH_DEPENDENCIES";

    /** Get parser results as chunks. */
    public static final String CHUNKS = "CHUNKS";

    /** Get parser results as dependencies. */
    public static final String DEPENDENCIES = "DEPENDENCIES";

}
