/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Assert;
import org.junit.Test;
import safar.modern_standard_arabic.basic.syntax.posTagger.factory.PosFactory;
import safar.modern_standard_arabic.basic.syntax.posTagger.interfaces.IPos;

import java.io.File;

/**
 * To get the POS tags for an input text.
 *
 */
public class POSImplementationsTest {

    public String text = "نصف المغاربة"
            + " يعانون مشاكل نفسية . مغربي من بين اثنين لديه مشكل نفسي  , هل تعرف ماذا يعني هذا ؟ أنا شخصيا"
            + " لا أعرف . إذا عرفت قل لي . أنا مغربي زائد أنت مغربي تساوي مغربيين . فمن منا المريض النفسي ومن منا السليم ؟ طبعا"
            + " ، أنا المريض .";

    @Test
    public void test_SafarLightPOSImplementation_generateFile(){
        try {
            String directory = System.getProperty("user.dir");
            IPos pos = PosFactory.getSafarLightPOSImplementation();
            pos.tag(text,new File(directory + "POS.xml"));
        } catch(Exception e) {
            Assert.fail("Should not have thrown any exception");
        }

    }

    @Test
    public void test_SafarLightPOSImplementation(){
        try {
            IPos pos = PosFactory.getSafarLightPOSImplementation();
            pos.tag(text);
        } catch(Exception e) {
            Assert.fail("Should not have thrown any exception");
        }

    }

}
