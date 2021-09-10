package ee.taltech.iti0202.sum100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum100 {

    private static final int MAX_SOL = 222222222;
    private static final int REC_NUM = 0;
    private static final int FINISH_NUMBER = 0;
    private static final int MAX_SOL_LENGTH = 9;

    public static List<String> calcSums() {
        int save = 0;
        String recTry;
        List<String> solutions = new ArrayList<>();
        for (int i = 0; i < MAX_SOL; i++) {
            if (save == 0) {
                recTry = searchSolutions(MAX_SOL, REC_NUM);
                String[] recTryList = recTry.split("~");
                Collections.addAll(solutions, recTryList);
            } else recTry = searchSolutions(save, REC_NUM);
            String[] recTryList = recTry.split("~");
            Collections.addAll(solutions, recTryList);
            save = Integer.parseInt(solutions.get(solutions.size() - 1));
            solutions.remove(solutions.size() - 1);
            if (save == FINISH_NUMBER) {
                return calculateSolution(solutions);
            }
        }
        return new ArrayList<>();
    }

    public static String searchSolutions(int marks, int rec) {
        String markCreation = String.valueOf(marks);
        int number = 1;
        String solution = "";
        for (int i = 3; i < 10; i++) {
            markCreation = markCreation.replace(String.valueOf(i), "2");
        }
        while (markCreation.length() < MAX_SOL_LENGTH) {
            markCreation = "0" + markCreation;
        }
        if (rec == 1000) {
            return markCreation;
        }
        if (markCreation.equals("000000000")) {
            return "000000000";
        }
        for (int i = 0; i < markCreation.length(); i++) {
            switch (markCreation.substring(i, i + 1)) {
                case "0":
                    solution += "" + number;
                    number++;
                    break;
                case "1":
                    solution += "-" + number;
                    number++;
                    break;
                case "2":
                    solution += "+" + number;
                    number++;
                    break;
                default:
                    break;
            }
        }
        return solution + "~" + searchSolutions(Integer.parseInt(markCreation) - 1, rec + 1);
    }

    public static List<String> calculateSolution(List<String> allSolves) {
        List<String> solutions = new ArrayList<>();
        allSolves.stream().forEach(e -> {
            String sol = e.replace("+", " + ");
            sol = sol.replace("-", " - ");
            List<String> calc = Arrays.asList(sol.split(" "));
            boolean plus = true;
            int sum = 0;
            for (int i = 0; i < calc.size(); i++) {
                switch (calc.get(i)) {
                    case "+":
                        plus = true;
                        break;
                    case "-":
                        plus = false;
                        break;
                    default:
                        if (calc.get(i).length() != 0) {
                            if (plus) sum += Integer.parseInt(calc.get(i));
                            else sum -= Integer.parseInt(calc.get(i));
                        }
                        break;
                }
            }
            if (sum == 100 && !e.substring(0, 1).equals("+")) {
                solutions.add(e);
            }
        });
        return solutions;
    }


    public static void main(String[] args) {
        System.out.println(calcSums());
        System.out.println(calcSums().size());
    }
}
