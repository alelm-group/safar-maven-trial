/* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more informations see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */
package common.constants;

import java.util.ArrayList;
import java.util.List;


/**
 * The <code>Ontology</code> class is used to store constants that concerne
 * ontology.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @author REGRAGUI Yassir
 * @version 1.0
 */
public enum OntologyEnum {
     /** used to store the name of AWN ontology implementation. */
    AWN ("Arabic WordNet"),

     /** used to store the name of extended AWN ontology implementation. */
    AWN_EXT ("Extended Arabic WordNet");

    /** used to store the name of the ontology. */
    private String name;

    /**
     * Constructor.
     * @param name1 the name of the implementation
     */
    private OntologyEnum(final String name1) {
        this.name = name1;
    }

    /**
     * Returns the name of the ontology implementation.
     * @return the name of the ontology implementation
     */
    public String getName() {
        return name;
    }

    /**
     * returns the list of all Ontologies implementations names.
     * @return <code>List</code> of <code>String</code> containing all
     *         Ontologies implementations names.
     */
    public static List<String> getOntologyImplNames() {
        List<String> list = new ArrayList<String>();
        for (OntologyEnum a : OntologyEnum.values()) {
            list.add(a.getName());
        }
        return list;
    }
}
