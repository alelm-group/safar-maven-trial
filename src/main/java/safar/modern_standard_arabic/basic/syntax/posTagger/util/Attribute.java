package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import java.util.Arrays;
import java.util.List;

/**
 * The <tt>Attribute</tt> class is used to extracts Attributes values from
 * unknown words for to use them in the <tt>DecisionTreeModel</tt>.
 * @see DecisionTreeModel
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public abstract class Attribute {

    /** List of punctuation. */
    public static final List<String> PUNCTFORLIGHTPOS
            = Arrays.asList(".", "!", "?", "؛", ":", "؟", ",", "،");
    /**
     * Used for <tt>SafarLightPOS</tt>
     * Returns First char from word given in parameter.
     * @param word the input word.
     * @return word's first Char
     */
    public static String firstChar(String word) {
        if (!word.matches("\\w")) {
            if (word.length() == 0 || PUNCTFORLIGHTPOS.contains(word)) {
                return "||";
            } else {
                return "|" + word.charAt(0) + "|";
            }
        } else {
            return "| |";
        }
    }
    /**
     * Used for <tt>SafarLightPOS</tt>
     * Returns last Char from word given in parameter.
     * @param word the input word.
     * @return word's Last Char
     */
    public static String lastChar(String word) {
        if (!word.matches("\\w")) {
            if (word.length() == 0 || PUNCTFORLIGHTPOS.contains(word)) {
                return "||";
            } else {
                return "|" + word.charAt(word.length() - 1) + "|";
            }
        } else {
            return "| |";
        }
    }
    /**
     * Used for <tt>SafarLightPOS</tt>
     * Returns before Last Char from word given in parameter.
     * @param word the input word.
     * @return word's Before Last Char
     */
    public static String beforeLastChar(String word) {
        String result ;
        if (!word.matches("\\w")) {
            if (word.length() < 2 || PUNCTFORLIGHTPOS.contains(word)) {
                result = "||";
            } else {
                result = "|" + word.charAt(word.length() - 2) + "|";
            }
        } else {
            result = "| |";
        }
        return result;
    }
    /**
     * Used for <tt>SafarLightPOS</tt>
     * Returns second Char from word given in parameter.
     * @param word the input word.
     * @return second Char
     */
    public static String secondChar(String word) {
        if (!word.matches("\\w")) {
            if (word.length() < 2 || PUNCTFORLIGHTPOS.contains(word)) {
                return "||";
            } else {
                return "|" + word.charAt(1) + "|";
            }
        } else {
            return "| |";
        }
    }
    /**
     * Used for <tt>SafarLightPOS</tt>
     * Returns third Char from word given in parameter.
     * @param word the input word.
     * @return third Char
     */
    public static String thirdChar(String word) {
        if (!word.matches("\\w")) {
            if (word.length() < 3 || PUNCTFORLIGHTPOS.contains(word)) {
                return "||";
            } else {
                return "|" + word.charAt(2) + "|";
            }
        } else {
            return "| |";
        }
    }
    /**
     * Check if the word given in parameter is contains an Arabic Character.
     * @param word
     * @return <code>boolean</code> result.
     */
    public static boolean isArabicLetter(char word) {
        List<Character> s = Arrays.asList('ا', 'ب', 'ت', 'ث', 'ج', 'ح', 'خ',
                'د', 'ذ', 'ر', 'ز', 'س', 'ش', 'ص', 'ض', 'ط', 'ظ', 'ع', 'غ',
                'ف', 'ق', 'ك', 'ل', 'م', 'ن', 'ه', 'و', 'ي', 'ء', 'أ', 'إ', 
                'آ', 'ة', 'ؤ', 'ئ', 'ى');
        return s.contains(word);
    }
    /**
     * Check if the word given in parameter is symbol.
     * @param word
     * @return true if the word is not a symbol.
     */
    public static boolean isLetter(String word) {
        List<String> PUNCT = Arrays.asList("؛", "؟", "،");
        return !word.matches("\\d") && !word.matches("\\p{Punct}") && 
                !word.matches("\\p{Alnum}") && !PUNCT.contains(word);
    }
    
}
