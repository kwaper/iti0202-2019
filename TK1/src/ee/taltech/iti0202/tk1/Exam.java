package ee.taltech.iti0202.tk1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {


    /**
     * Return a list that contains the exact same numbers as the given list, but rearranged so that
     * all the even numbers come before all the odd numbers. Other than that, the numbers can be in
     * any order. You may modify and return the given list, or make a new list.
     * <p>
     * <p>
     * evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
     * evenOdd([3, 3, 2]) → [2, 3, 3]
     * evenOdd([2, 2, 2]) → [2, 2, 2]
     */
    public static List<Integer> evenOdd(List<Integer> nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (Integer x : nums) {
            if (x % 2 == 0) {
                even.add(x);
            } else odd.add(x);
        }
        for (Integer e : even) {
            newList.add(e);
        }
        for (Integer o : odd) {
            newList.add(o);
        }
        return newList;
    }


    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
     * it does not count towards the sum.
     * <p>
     * loneSum(1, 2, 3) → 6
     * loneSum(3, 2, 3) → 2
     * loneSum(3, 3, 3) → 0
     */
    public static int loneSum(int a, int b, int c) {
        if (a != b && a != c && b != c) {
            return a + b + c;
        } else if (a == b && a != c) {
            return c;
        } else if (b == c && b != a) {
            return a;
        } else if (c == a && c != b) {
            return b;
        }
        return 0;
    }


    /**
     * A sandwich is two pieces of bread with something in between. Return the string that is between the first and
     * last appearance of "bread" in the given string, or return the empty string ""
     * if there are not two pieces of bread.
     * <p>
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */

    private static final int MIN_LENGTH = 11;

    public static String getSandwich(String str) {
        if (str.length() < MIN_LENGTH) {
            return "";
        }
        int countBread = 0;
        for (int i = 0; i < str.length() - 4; i++) {
            if (str.substring(i, i + 5).equals("bread")) {
                countBread++;
            }
        }
        if (countBread > 1) {
            int a = str.indexOf("bread");
            int b = str.lastIndexOf("bread");
            return str.substring(a + 5, b);
        } else return "";

    }


    /**
     * Given a map of food keys and topping values, modify and return the map as follows: if the key
     * "ice cream" is present, set its value to "cherry". In all cases, set the key "bread"
     * to have the value "butter".
     * <p>
     * <p>
     * topping({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
     * topping({}) → {"bread": "butter"}
     * topping({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
     */
    public static Map<String, String> topping(Map<String, String> map) {
        Map<String, String> newMap = new HashMap<>();
        for (String x : map.keySet()) {
            if (x == "ice cream") {
                newMap.put(x, "cherry");
            } else newMap.put(x, map.get(x));
        }
        newMap.put("bread", "butter");
        return newMap;
    }
}
