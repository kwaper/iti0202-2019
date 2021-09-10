package ee.taltech.iti0202.kt5;

import java.util.Arrays;
import java.util.List;

public class Exam {

    /**
     * Given an array of ints,
     * return true if the value 3 appears in the array exactly 3 times,
     * and no 3's are next to each other.
     * <p>
     * haveThree([3, 1, 3, 1, 3]) => true
     * haveThree([3, 1, 3, 3]) => false
     * haveThree([3, 4, 3, 3, 4]) => false
     */
    public static boolean haveThree(List<Integer> nrs) {
        boolean canbethree = true;
        int counter = 0;
        if (nrs.size() > 0) {
            for (Integer i : nrs) {
                if (i == 3 && counter >= 3){
                    return false;
                }
                if (i == 3 && canbethree) {
                    counter++;
                    canbethree = false;
                }
                if (i != 3 && !canbethree) {
                    canbethree = true;
                }

            }
        }
        return counter == 3;
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
        String[] first = a.split("");
        String[] second = b.split("");
        String fin = "";
        if (a.length() == 0 && b.length() == 0){
            return fin;
        }
        for (int i = 0; i < a.length() + b.length() ; i++){
            if (first.length > i){
                fin += first[i];
            }
            if (second.length > i){
                fin += second[i];
            }
        } return fin;
    }


    public static void main(String[] args) {
        System.out.println(haveThree(Arrays.asList()));
        System.out.println(mixString("xxxx", "There"));
    }
}
