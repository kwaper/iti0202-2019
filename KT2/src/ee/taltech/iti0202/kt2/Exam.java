package ee.taltech.iti0202.kt2;

import java.util.List;

public class Exam {
    /**
     * Given lists nums1 and nums2 of the same length,
     * for every element in nums1, consider the corresponding
     * element in nums2 (at the same index).
     * Return the count of the number of times
     * that the two elements differ by 2 or less, but are not equal.
     * <p>
     * matchUp([1, 2, 3], [2, 3, 10]) => 2
     * matchUp([1, 2, 3], [2, 3, 5]) => 3
     * matchUp([1, 2, 3], [2, 3, 3]) => 2
     */
    public static int matchUp(List<Integer> a, List<Integer> b) {
        return -1;
    }

    /**
     * Given two strings, word and a separator sep,
     * return a big string made of count occurrences of the word,
     * separated by the separator string.
     * <p>
     * repeatSeparator("Word", "X", 3) => "WordXWordXWord"
     * repeatSeparator("This", "And", 2) => "ThisAndThis"
     * repeatSeparator("This", "And", 1) => "This"
     */
    public static String repeatSeparator(String word, String sep, int count) {
//        String str = "";
//        if (count == 1) {
//            return word;
//        }
//        if (count == 0) {
//            return str;
//        }
//        if (count > 1) {
//            for (int i = 0; i <= count; i++) {
//                if (i < count - 1) {
//                    str += word;
//                    str += sep;
//                } else if (i == count) {
//                    str += word;
//                }
//            }
//
//        }
//        return str;
        String lolkek = word + sep;
        String y = "";
        for (int i = 0; i <= count; i++) {
            y += lolkek;
        }
        return y.substring(0, y.length() - sep.length());


    }

    public static void main(String[] args) {
        System.out.println(repeatSeparator("AA", "bb", 1));
    }
}
