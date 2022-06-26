 /* SAFAR Platform.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

 import org.junit.Assert;
 import org.junit.Test;
 import safar.modern_standard_arabic.basic.morphology.stemmer.factory.StemmerFactory;
 import safar.modern_standard_arabic.basic.morphology.stemmer.interfaces.IStemmer;

 import java.io.File;

 /**
  * Stemmers Tests : save stemming results as xml file.
  * For mor information, see the javadoc at :
  * http://arabic.emi.ac.ma/safar/javadoc/index.html
  * or the examples at :
  * http://arabic.emi.ac.ma/safar/?q=examples##Stemmer
  *
  * @author BOUZOUBAA Karim
  * @author JAAFAR Younes
  * @version 1.0
  */
 public class StemmerImplementationsTests {
     public String text  = "مصر أو رسميًا جمهورية مصر العربية، دولة عربية"
             + " تقع في أقصى الشمال الشرقي من قارة أفريقيا،"
             + " وتقع أيضاَ في أقصى الجنوب الغربي من قارة أسيا"
             + " يحدها من الشمال الساحل الجنوبي الشرقي للبحر"
             + " المتوسط ومن الشرق الساحل الشمالي الغربي للبحر الأحمر"
             + " ومساحتها 1,002,450 كيلومتر مربع. مصر دولة تقع"
             + " معظم أراضيها في أفريقيا غير أن جزءا من أراضيها،"
             + " وهي شبه جزيرة سيناء، يقع في قارة آسيا، فهي"
             + " دولة عابرة للقارات. تشترك مصر بحدود من الغرب"
             + " مع ليبيا، ومن الجنوب مع السودان، ومن الشمال "
             + " الشرقي مع إسرائيل وقطاع غزة، وتطل على"
             + " البحر الأحمر من الجهة الشرقية.";

     @Test
     public void test_Light10Implementation() {
         try {
             IStemmer stemmer = StemmerFactory.getLight10Implementation();
             stemmer.stem(text);
         } catch(Exception e) {
             Assert.fail("Should not have thrown any exception");
         }

     }

 }
