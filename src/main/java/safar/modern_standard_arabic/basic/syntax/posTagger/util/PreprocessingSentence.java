/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safar.modern_standard_arabic.basic.syntax.posTagger.util;

import safar.modern_standard_arabic.util.normalization.impl.SAFARNormalizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The <tt>PreProcessingSentence</tt> class is used to Normalize and split
 * the input text into sentences and to return the indexes of each word in the
 * vocabulary if it exists.
 *
 * @author SI Lhoussain AOURAGH
 * @author BOUZOUBAA Karim
 * @author TNAJI Khalid
 */
public abstract class PreprocessingSentence {

    /**
     * Returns the indexes of each word from the vocabulary.
     *
     * @param sentence the input sentences.
     * @param vocabulary
     * @return indexes of sentence's words in the vocabulary
     */
    public static List<Integer> sentenceWordsIndexes(String sentence[],
                                                     List<String> vocabulary) {
        List<Integer> indexs = new ArrayList<>();
        for (String santance1 : sentence) {
            indexs.add(vocabulary.indexOf(santance1));
        }
        return indexs;
    }

    /**
     * Remove diacritics and undesired characters and returns a normalized
     * text as result.
     *
     * @param textIn input text
     * @return Normalized Text
     */
    public static String stringNormalizer(String textIn) {
        List<String> punct = Arrays.asList(".", "!", "?", "؛",
                ":", "؟", ",", ";","،");
        String normalizedText = textIn, words[], t;
        normalizedText = getSentenceWithSimpleSpace(normalizedText);
        for (int i = 0; i < normalizedText.length(); i++) {
            char charAt = normalizedText.charAt(i);
            if (punct.contains("" + charAt)) {
                normalizedText = normalizedText.replace("" + charAt, " " + charAt + " ");
                punct.set(punct.indexOf("" + charAt), "  ");
            }
        }
        normalizedText = getSentenceWithSimpleSpace(normalizedText);
        words = normalizedText.split(" ");
        SAFARNormalizer normalizer = new SAFARNormalizer();
        normalizedText = "";
        punct = Arrays.asList(".", "!", "?", "؛", ":", "؟", ",", ";","،");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replace(" ", "");
            t = words[i];
            if (!punct.contains(words[i])) {
                t = normalizer.normalize(words[i]);
                normalizedText += " " + t;
            } else if (punct.contains(t)) {
                normalizedText += " " + words[i];
            }
        }
        normalizedText = getSentenceWithSimpleSpace(normalizedText);
        normalizedText = normalizedText.substring(1, normalizedText.length());
        normalizedText = normalizedText.replaceAll("[ًٌٍَُِّْ]", "");
        return normalizedText;
    }

    private static String getSentenceWithSimpleSpace(String normalizedText) {
        while (normalizedText.contains("  ")) {
            normalizedText = normalizedText.replace("  ", " ");
        }
        return normalizedText;
    }

    /**
     * Split the input text given in parameter into sentences.
     *
     * @param text normalized text
     * @return Array of sentences.
     */
    public static String[] sentenceSplitterUpdated(String text) {
        String sentences[], words[], sentence = "";
        List<String> S = new ArrayList<>(),
                punct = Arrays.asList(".", "!", "?", "؟");
        if (text.contains(" ")){
            words = text.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!punct.contains(words[i]) && i != words.length - 1) {
                    sentence += " " + words[i];
                } else {
                    sentence += " " + words[i];
                    if (sentence.charAt(0) == ' '
                            & sentence.charAt(sentence.length() - 1) == ' ') {
                        sentence = sentence.substring(1, sentence.length() - 1);
                    } else if (sentence.charAt(0) == ' ') {
                        sentence = sentence.substring(1);
                    } else if (sentence.charAt(sentence.length() - 1) == ' ') {
                        sentence = sentence.substring(0, sentence.length() - 1);
                    }
                    S.add(sentence);
                    sentence = "";
                }
            }
            sentences = new String[S.size()];
            for (int i = 0; i < S.size(); i++) {
                sentences[i] = S.get(i);
            }
         }else  {
            sentences = new String[1];
            sentences[0] = text;
        }

        return sentences;
    }

}
