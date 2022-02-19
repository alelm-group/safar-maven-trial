/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.util.normalization.interfaces;

import java.io.File;

/**
 *
 * @author Younes
 */
public interface INormalizer0 {

    /**
     * Normalizes a text by deleting all non arabic letters, all special
     * characters, kashida, all words containing digits and all words composed
     * of only one letter or one digit.
     * @param text text to be normalized
     * @return a <tt>String</tt> containing the normalized text
     */
    String normalize(String text);

    /**
     * Normalizes the text specified in the first parameter according to the
     * formOfNormalization and otherCharsToDelete parameters.
     * @param text text to be normalized
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
    String normalize(
            String text,
            String formOfNormalization,
            String otherCharsToDelete);

    /**
     * Normalizes the content of the <code>File</code> specified in the first
     * parameter by deleting all non arabic letters, all special characters,
     * kashida, all words containing digits and all words composed of only one
     * letter or one digit.
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @return a <tt>String</tt> containing the normalized text
     */
    String normalize(
            File inputFile,
            String inputEncoding);

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
    String normalize(
            File inputFile,
            String inputEncoding,
            String formOfNormalization,
            String otherCharsToDelete);

    /**
     * Normalizes a text by deleting all non arabic letters, all special
     * characters, kashida, all words containing digits and all words composed
     * of only one letter or one digit, and saves result as <code>File</code>.
     * @param text text to be nozmalized
     * @param outputFile <tt>File</tt> in which result will be saved.
     */
    void normalize(String text, File outputFile);

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
    void normalize(
            String text,
            File outputFile,
            String formOfNormalization,
            String otherCharsToDelete);

    /**
     * Normalizes the content of the specified <code>File</code> by deleting all
     * non arabic letters, all special characters, kashida, all words containing
     * digits and all words composed of only one, and saves result as <code>File
     * </code>.
     * @param inputFile <tt>File</tt> to be normalized
     * @param inputEncoding encoding of the input <tt>File</tt>
     * @param outputFile <tt>File</tt> in which result will be saved.
     */
    void normalize(
            File inputFile,
            String inputEncoding,
            File outputFile);

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
    void normalize(
            File inputFile,
            String inputEncoding,
            File outputFile,
            String formOfNormalization,
            String otherCharsToDelete);
}
