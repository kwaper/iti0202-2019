package ee.taltech.iti0202.kt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam {
    /**
     * Returns numbers before the last 4 and after the second last 4.
     * If there is only one 4 in the list, takes all the elements before that.
     * If there is no 4 in the list, returns the whole list.
     * <p>
     * between4([1, 4, 2, 3, 4, 5]) => [2, 3]
     * between4([1, 4, 1, 4, 2, 3, 4, 5]) => [2, 3]
     * between4([1, 2, 4, 2, 3]) => [1, 2]
     * between4([1, 2, 4, 4, 3]) => []
     * between4([1, 2, 3]) => [1, 2, 3]
     */
    public static List<Integer> between4(List<Integer> numbers) {
        List<Integer> indexFours = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                indexFours.add(i);
            }
        }
        System.out.println(indexFours);
        if (indexFours.size() == 0) {
            return numbers;
        }
        if (indexFours.size() == 1) {
            return numbers.subList(0, indexFours.get(0));
        }
        return numbers.subList(indexFours.get(indexFours.size() - 2) + 1, indexFours.get(indexFours.size() - 1));
    }


    /**
     * Given two strings, a and b,
     * create a bigger string made of the first char of a, the first char of b,
     * the second char of a, the second char of b, and so on.
     * Any leftover chars go at the end of the result.
     * <p>
     * mixString("abc", "xyz") => "axbycz"
     * mixString("Hi", "There") => "HTihere"
     * mixString("xxxx", "There") => "xTxhxexre"
     */
    public static String mixString(String a, String b) {
        int maxLength = 0;
        String string = "";

        if (a.length() < b.length()) {
            maxLength = b.length();
        } else if (a.length() > b.length()) {
            maxLength = a.length();
        } else maxLength = a.length();
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                string += a.charAt(i);
            }
            if (i < b.length()) {
                string += b.charAt(i);
            }
        }
        return string;


    }

    public static void main(String[] args) {
        System.out.println(mixString("HELLO", "A"));
        System.out.println(mixString("a", "HELLO"));
        System.out.println(mixString("", ""));
        System.out.println(mixString("AAA", ""));
        System.out.println(mixString("", "AAA"));
        System.out.println(mixString("HELLO", "hello"));


    }
}
