package ee.taltech.iti0202.strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {
    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : sentence) {
            Integer appear = map.get(word);
            if (appear == null) map.put(word, 1);
            else map.put(word, appear + 1);
        }
        return map;
    }


    /**
     * Find the most frequent word in given array of strings.
     * <p>
     * If there are multiple most frequent words to choose from pick any of them.
     *
     * @param sentence array of strings, can't be null.
     * @return most frequent word in the sentence
     */
    public static String mostFrequentWord(String[] sentence) {
        Map<String, Integer> map = new HashMap<>(wordCount(sentence));
        String word = "";
        Integer count = 0;
        for (String w : map.keySet()) {
            if (count < map.get(w)) {
                count = map.get(w);
                word = w;
            }
        }
        return (sentence.length > 0) ? word : null;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> items = new ArrayList<String>();
        for (String word : words) {
            if (map.get(word) == null) {
                map.put(word, 1);
            } else map.put(word, map.get(word) + 1);
            if (map.get(word) == 2) {
                items.add(word);
                map.put(word, 0);
            }
        }
        return items;
    }

    /**
     * Loop over the given string to build a result string like this:
     * when a character appears the 2nd, 4th, 6th, etc. time in the string, append the character to the result.
     * <p>
     * Return the empty string if no character appears a 2nd time.
     * <p>
     * Use map to count times that character has appeared.
     * Easy way to get char array (char[]) from string: input.toCharArray();
     *
     * @param input string
     * @return string
     */
    public static String onlyEvenCharacters(String input) {
        Map<String, Integer> map = new HashMap<>();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            String charr = input.substring(i, i + 1);
            if (map.get(charr) == null) {
                map.put(charr, 1);
            } else map.put(charr, map.get(charr) + 1);
            if (map.get(charr) != 0 && map.get(charr) % 2 == 0) {
                output += charr;
            }
        }
        return output;
    }
}
