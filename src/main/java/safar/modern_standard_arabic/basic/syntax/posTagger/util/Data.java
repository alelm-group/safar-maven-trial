/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * The <tt>Data</tt> class is used to Desrializing files using a generic
 * parameter.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public class Data<T> {
    /**
     * Desrialize the file given in parameter,
     * and returns an instance object.
     * @param fileName the file name with his extension.
     * @return an object of type T.
     */
    public  T getData(final String fileName)  {
        T object = null;
        try {
            ClassLoader c1 = Thread.currentThread().getContextClassLoader();
            InputStream s1 = c1.getResourceAsStream(
                    "safar/modern_standard_arabic/basic/syntax/posTagger/data/"+fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(s1);
            object = (T) objectInputStream.readObject();
            objectInputStream.close();
            s1.close();
       } catch (IOException | ClassNotFoundException e) {
      }
      
        return object;
    }
}
