import org.junit.Assert;
import org.junit.Test;
import safar.machine_learning.levenshtein.factory.LevenshteinFactory;
import safar.machine_learning.levenshtein.interfaces.ILevenshtein;

public class LevenshteinTest {


    @Test
    public void test_Levenshtein() {
        try {
            System.out.println("-----------------------------------------------");
            System.out.println("-----------------------------------------------");
            System.out.println("----------Test for SAFAR Levenshtein ----------");
            System.out.println("-----------------------------------------------");
            System.out.println("-----------------------------------------------");
            String w1 = "بَعْدِهِ";
            String w2 = "بَعُدَ";
            System.out.println("Word 1: " + w1);
            System.out.println("Word 2: " + w2);
            ILevenshtein safarLevFactory = LevenshteinFactory.getSAFARImplementation();
            int safarLev = safarLevFactory.getLevenshtein(w1, w2);
            System.out.println("Levenshtein distance is : " + safarLev);
        } catch(Exception e) {
            Assert.fail("Should not have thrown any exception");
        }

    }
}