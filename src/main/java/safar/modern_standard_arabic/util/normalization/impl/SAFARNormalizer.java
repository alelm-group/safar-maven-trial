 /* SAFAR - Open source programm.
 *
 * Copyright (C) 2013.
 *
 * This program is free software, distributed under the terms of
 * the GNU General Public License Version 3. For more information see web
 * site at : http://www.gnu.org/licenses/gpl.txt
 */

package safar.modern_standard_arabic.util.normalization.impl;

import common.manage_errors.Errors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import safar.modern_standard_arabic.util.normalization.interfaces.INormalizer;

/**
 * The <tt>SAFARNormalizer</tt> class is a set of utilities allowing
 * normalization of an input (string or File) by deleting some elements.
 *
 * @author BOUZOUBAA Karim
 * @author JAAFAR Younes
 * @version 1.0
 */
public class SAFARNormalizer implements INormalizer {

    /**
     * Normalizes a text by deleting all non arabic letters, all special
     * characters, kashida, all words containing digits and all words composed
     * of only one letter or one digit.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalize(final String text) {
        return normalize(text, "NonArabicNumbersWordsContainingDigits"
                + "SingleCharDiacriticsPunctuation", "");
    }
    
    /**
     * Normalizes a text by deleting all non arabic letters.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizeNonArabic(final String text) {
        return normalize(text, "NonArabic", "");
    }
    
    /**
     * Normalizes a text by deleting all Numbers.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizeNumbers(final String text) {
        return normalize(text, "Numbers", "");
    }
    
    /**
     * Normalizes a text by deleting all Words Containing Digits.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizeWordsContainingDigits(final String text) {
        return normalize(text, "WordsContainingDigits", "");
    }
    
    /**
     * Normalizes a text by deleting all Single Char.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizeSingleChar(final String text) {
        return normalize(text, "SingleChar", "");
    }
    
    /**
     * Normalizes a text by deleting all Diacritics.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizeDiacritics(final String text) {
        return normalize(text, "Diacritics", "");
    }
    
    /**
     * Normalizes a text by deleting all Punctuation.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalizePunctuation(final String text) {
        return normalize(text, "Punctuation", "");
    }
    

    /**
     * Normalizes the text specified in the first parameter according to the
     * formOfNormalization and otherCharsToDelete parameters.
     * @param text text to be normalized
     * @param formOfNormalization a String composed of one or multiple
     *                            instruction (NonArabic, Numbers,
     *                            WordsContainingDigits, SingleChar or
     *                            DiacriticsPunctuation).<br>
     *                            a/NonArabic : to delete all special and non  
     *                            arabic characters (numbers are not concerned)
     *                                <br>
     *                            b/Numbers : to delete all words that are
     *                                composed of digits only (numbers)<br>
     *                            c/WordsContainingDigits : to delete all words
     *                                that are composed of both digits
     *                                 and letters or only digits<br>
     *                            d/SingleChar : to delete all words that are
     *                                composed of only one character<br>
     *                            Diacritics : to delete Diacritics.<br>
     *                            Punctuation : to delete all Punctuation marks.
     *                            <br><b>e.g.:</b> the "abcd" form will
     *                            remove all elements previously mentioned, the
     *                            "bc" form will remove every word containing a
     *                            digit.
     *                            <br>
     *                            If this parameter is an empty String, Non of
     *                            the above operations will be executed
     * @param otherCharsToDelete a String (can be empty) composed of the other 
     *                           individual characters to delete (separated
     *                            with white spaces)
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalize(
            final String text,
            final String formOfNormalization,
            final String otherCharsToDelete) {

        String normalizedText = text;
        String formOfNormalizationTemp = "";
        String otherCharsToDeleteTemp = "";

        if (formOfNormalization != null) {
            formOfNormalizationTemp = formOfNormalization;
        }
        if (otherCharsToDelete != null) {
            otherCharsToDeleteTemp = otherCharsToDelete;
        }

        // delete all special characters and non arabic letters
        // (numbers are not concerned)
        if (formOfNormalizationTemp.contains("NonArabic")) {
            normalizedText = text.replaceAll("([^\\p{Punct}\\p{InArabic}\\s0123456789\u064E\u0621"
                + "\u0629\u064B\u064F\u064C\u0650\u0625\u064D\u0652\u0651\u0626"
                + "\u0624\u0622\u0623\u0627\u0628\u062A\u062B\u062C\u062D\u062E"
                + "\u062F\u0630\u0631\u0632\u0633\u0634\u0635\u0636\u0637"
                + "\u0638\u0639\u063A\u0641\u0642\u0643\u0644\u0645\u0649"
                + "\u0646\u0647\u0648\u064A\u0640])", "");
            normalizedText = normalizedText.replaceAll("\u0640", "");
        }
//         delete all words containing digits only(e.g : 1986)
        if (formOfNormalizationTemp.contains("Numbers")) {
            String[] tokens = normalizedText.split("\\s+");
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile(".*[^0-9].*");
            for (String token : tokens) {
                Matcher m = p.matcher(token);
                if (m.matches()) {
                    sb.append(token);
                    sb.append(" ");
                }
            }
            normalizedText = sb.toString();
        }
        // delete all words containing a digit (e.g : 3000m)
        if (formOfNormalizationTemp.contains("WordsContainingDigits")) {
            String[] tokens = normalizedText.split("\\s+");
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile(".*[0-9].*");
            for (String token : tokens) {
                Matcher m = p.matcher(token);
                if (!m.matches()) {
                    sb.append(token);
                    sb.append(" ");
                }
            }
            normalizedText = sb.toString();
        }
        // delete all words that are composed of only one letter or one digit.
        if (formOfNormalizationTemp.contains("SingleChar")) {
            String[] tokens = normalizedText.split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (String token : tokens) {
                if (token.length() > 1) {
                    sb.append(token.trim());
                    sb.append(" ");
                }
            }
            normalizedText = sb.toString();
        }
        // delete all diacritics.
        if (formOfNormalizationTemp.contains("Diacritics")) {
            normalizedText = normalizedText.replaceAll("[ًٌٍَُِّْ]", "");
        }
        if (formOfNormalizationTemp.contains("Punctuation")) {
            normalizedText = normalizedText.replaceAll("\\p{P}", "");
        }
        // Delete also characters specified in otherCharsToDelete parameter
        if (!otherCharsToDeleteTemp.trim().equals("")) {
            String[] specialChars = otherCharsToDeleteTemp.trim().split("\\s+");
            for (String specialChar : specialChars) {
                if (!specialChar.trim().equals("")) {
                    normalizedText = normalizedText.replace(specialChar.trim(),
                            "");
                }
            }
        }
        return normalizedText;
    }

    /**
     * Normalizes the content of the <code>File</code> specified in the first
     * parameter by deleting all non arabic letters, all special characters,
     * kashida, all words containing digits and all words composed of only one
     * letter or one digit.
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalize(
            final File inputFile,
            final String inputEncoding) {
        return normalize(inputFile, inputEncoding, "NonArabicNumbers"
                + "WordsContainingDigitsSingleCharDiacriticsPunctuation", "");
    }

    /**
     * Normalizes the content of the <code>File</code> specified in the first
     * parameter according to the "formOfNormalization" and "otherCharsToDelete"
     * parameters.
     *
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param formOfNormalization a String composed of concatenation of letters
     *                            "a", "b", "c" and "d".<br>
     *                            a : to delete all special characters and non
     *                                arabic letters (numbers are not concerned)
     *                                <br>
     *                            b : to delete all words that are composed of
     *                                digits only (numbers)<br>
     *                            c : to delete all words that are composed of
     *                                both digits and letters or only digits
     *                                <br>
     *                            d : to delete all words that are composed of
     *                                only one character.
     *                            <br><b>e.g.:</b> the "abcd" form will
     *                            remove all elements previously mentioned, the
     *                            "bc" form will remove every word containing a
     *                            digit.
     *                            <br>
     *                            If this parameter is an empty String, Non of
     *                            the above operations will be executed
     * @param otherCharsToDelete other individual characters to delete
     *                           (separated with white spaces)
     * @return a <tt>String</tt> containing the normalized text
     */
    @Override
    public String normalize(
            final File inputFile,
            final String inputEncoding,
            final String formOfNormalization,
            final String otherCharsToDelete) {

        StringBuilder normalizedText = new StringBuilder();
        try {
//            URL url = inputFile.toURL();
//            URLConnection connection = url.openConnection();
//            if (connection.getContentType().equals("text/plain")) {
                FileInputStream fis = new FileInputStream(inputFile);
                InputStreamReader ipsr = new InputStreamReader(fis,
                        inputEncoding);
                BufferedReader brd = new BufferedReader(ipsr);
                String in;
                while ((in = brd.readLine()) != null) {
                        normalizedText.append(normalize(in, formOfNormalization,
                                                        otherCharsToDelete));
                        normalizedText.append("\n");
                }
                brd.close();
                fis.close();
//            } else {
//                Errors.manageError("Error", "The input should be a text file")
//                ;
//            }
        } catch (IOException e) {
            Errors.manageError("Exception", e.getMessage());
        }
        return normalizedText.toString();
    }

    /**
     * Normalizes a text by deleting all non arabic letters, all special
     * characters, kashida, all words containing digits and all words composed
     * of only one letter or one digit, and saves result as <code>File</code>.
     * @param text text to be nozmalized
     * @param outputFile <tt>File</tt> in which result will be saved.
     */
    @Override
    public void normalize(final String text, final File outputFile) {
        saveNormalizationResultAsFile(normalize(text), outputFile);
    }

    /**
     * Normalizes a text according to the "formOfNormalization" and
     * "otherCharsToDelete" parameters and and saves result as
     * <code>File</code>.
     * @param text text to be nozmalized
     * @param outputFile <tt>File</tt> in which result will be saved.
     * @param formOfNormalization a String composed of concatenation of letters
     *                            "a", "b", "c" and "d".<br>
     *                            a : to delete all special characters and non
     *                                arabic letters (numbers are not concerned)
     *                                <br>
     *                            b : to delete all words that are composed of
     *                                digits only (numbers)<br>
     *                            c : to delete all words that are composed of
     *                                both digits and letters or only digits
     *                                <br>
     *                            d : to delete all words that are composed of
     *                                only one character.
     *                            <br><b>e.g.:</b> the "abcd" form will
     *                            remove all elements previously mentioned, the
     *                            "bc" form will remove every word containing a
     *                            digit.
     *                            <br>
     *                            If this parameter is an empty String, Non of
     *                            the above operations will be executed
     * @param otherCharsToDelete other individual characters to delete
     *                           (separated with white spaces)
     */
    @Override
    public void normalize(
            final String text,
            final File outputFile,
            final String formOfNormalization,
            final String otherCharsToDelete) {
        saveNormalizationResultAsFile(
                normalize(text, formOfNormalization, otherCharsToDelete),
                outputFile);
    }

    /**
     * Normalizes the content of the specified <code>File</code> by deleting all
     * non arabic letters, all special characters, kashida, all words containing
     * digits and all words composed of only one, and saves result as <code>File
     * </code>.
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param outputFile <tt>File</tt> in which result will be saved.
     */
    @Override
    public void normalize(
            final File inputFile,
            final String inputEncoding,
            final File outputFile) {
        saveNormalizationResultAsFile(
                normalize(inputFile, inputEncoding),
                outputFile);
    }

    /**
     * Normalizes the content of the specified <code>File</code> according to
     * the "formOfNormalization" and "otherCharsToDelete" parameters, and saves
     * result as <code>File
     * </code>.
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param outputFile <tt>File</tt> in which result will be saved.
     * @param formOfNormalization a String composed of concatenation of letters
     *                            "a", "b", "c" and "d".<br>
     *                            a : to delete all special characters and non
     *                                arabic letters (numbers are not concerned)
     *                                <br>
     *                            b : to delete all words that are composed of
     *                                digits only (numbers)<br>
     *                            c : to delete all words that are composed of
     *                                both digits and letters or only digits
     *                                <br>
     *                            d : to delete all words that are composed of
     *                                only one character.
     *                            <br><b>e.g.:</b> the "abcd" form will
     *                            remove all elements previously mentioned, the
     *                            "bc" form will remove every word containing a
     *                            digit.
     *                            <br>
     *                            If this parameter is an empty String, Non of
     *                            the above operations will be executed
     * @param otherCharsToDelete other individual characters to delete
     *                           (separated with white spaces)
     */
    @Override
    public void normalize(
            final File inputFile,
            final String inputEncoding,
            final File outputFile,
            final String formOfNormalization,
            final String otherCharsToDelete) {
        saveNormalizationResultAsFile(
                normalize(inputFile, inputEncoding, formOfNormalization,
                          otherCharsToDelete),
                outputFile);
    }

     /* ---------------------------- Utilities -------------------------------*/

    /**
     * Saves the specified text in the outputFile.
     * @param normalizedText text to be saved
     * @param outputFile output File in which the text will be saved
     */
    private void saveNormalizationResultAsFile(
        final String normalizedText,
        final File outputFile) {
            try {
                FileWriter fstream = new FileWriter(outputFile);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(normalizedText);
                out.close();
            } catch (IOException e) {
              System.err.println("Error: " + e.getMessage());
            }
    }
}
