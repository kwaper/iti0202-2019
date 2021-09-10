package ee.taltech.iti0202.recursion;

import java.util.Arrays;
import java.util.List;

public class Recursion {
    /**
     * Find the text between the first and last parenthesis.
     *
     * @param word a random word
     * @return content between first and last parenthesis
     */
    public static String parentheses(String word) {
        if (word.length() == 0) return "";
        if (word.substring(0, 1).equals("(") && word.contains(")")) {
            return word.substring(0, word.lastIndexOf(")") + 1);
        }
        return parentheses(word.substring(1));
    }

    /**
     * Remove every neighbouring duplicate char in the string recursively.
     *
     * @param word a word with duplicates
     * @return a word without any duplicates
     */
    public static String removeDuplicates(String word) {
        if (word.length() == 0) return "";
        if (word.length() > 1) {
            if (word.substring(0, 1).equals(word.substring(1, 2))) {
                return removeDuplicates(word.substring(1));
            } else return word.substring(0, 1) + removeDuplicates(word.substring(1));
        } else return word;
    }

    /**
     * Remove any char that isn't in the Pseudo Hawaiian pidgin language.
     *
     * @param word a word that may contain other chars
     * @return a word where only Hawaiian pidgin chars exist
     */
    public static String pidginfy(String word) {
        List<String> allowed = Arrays.asList("a", "e", "i", "o", "u", "h", "k", "l", "m", "n",
                "p", "w", "r", "'", " ", "ā", "ō", "ū", ".", ",", "!", "?");
        if (word.length() == 0) return "";
        if (allowed.contains(word.substring(0, 1).toLowerCase())) {
            return word.substring(0, 1) + pidginfy(word.substring(1));
        } else return pidginfy(word.substring(1));
    }
}
