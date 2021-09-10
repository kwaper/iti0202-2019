package ee.taltech.iti0202.cpu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cpu {

    private static final int NUMBER_TO_COMPARE = 6;
    private static final int NEXT_LINE = 7;

    public static Map<String, Integer> compute(String instructions) {
        ArrayList<String> items = new ArrayList<String>();
        String[] input = instructions.split("\\s");
        for (int i = 0; i < input.length; i++) {
            items.add(input[i]);
        }
        return variables(items);
    }

    public static Map<String, Integer> variables(List<String> words) {
        Map<String, Integer> vars = new HashMap<>();
        if (!words.isEmpty()) {
            for (int i = 0; i < words.size(); i += NEXT_LINE) {
                vars.putIfAbsent(words.get(i), 0);
            }
            return ifSentenceCreator(words, vars);
        }
        return new HashMap<>();
    }

    public static Map<String, Integer> ifSentenceCreator(List<String> sentence, Map<String, Integer> map) {
        for (int i = 0; i < sentence.size(); i += NEXT_LINE) {
            int varIntToCompare = map.get(sentence.get(4 + i));
            int numberValueToCompare = Integer.parseInt(sentence.get(NUMBER_TO_COMPARE + i));
            String incDecChecker = sentence.get(1 + i);
            int varValueChange = Integer.parseInt(sentence.get(2 + i));
            String compareSymbol = sentence.get(5 + i);
            switch (compareSymbol) {
                case ">":
                    if (varIntToCompare > numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare > numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;
                case "<":
                    if (varIntToCompare < numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare < numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;

                case ">=":
                    if (varIntToCompare >= numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare >= numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;

                case "<=":
                    if (varIntToCompare <= numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare <= numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;

                case "==":
                    if (varIntToCompare == numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare == numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;

                case "!=":
                    if (varIntToCompare != numberValueToCompare && incDecChecker.equals("inc")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) + varValueChange);
                    } else if (varIntToCompare != numberValueToCompare && incDecChecker.equals("dec")) {
                        map.put(sentence.get(i), map.get(sentence.get(i)) - varValueChange);
                    }
                    break;

                default:
                    break;
            }
        }
        System.out.println(map);
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> res = compute(
                "b inc 5 if a > 1\n" +
                        "a inc 1 if b < 5\n" +
                        "c dec -10 if a >= 1\n" +
                        "c inc -20 if c == 10"
        );
        System.out.println(res); // {a=1, b=0, c=-10}

        res = compute(
                "b inc 7 if a > 4\n" +
                        "a inc 1 if c < 13\n" +
                        "c dec -10 if a >= 1\n" +
                        "c inc -20 if c == 10\n" +
                        "abc inc 100 if a != -23\n" +
                        "a inc 2 if a <= 0"
        );
        System.out.println(res); // {a=1, b=0, c=-10, abc=100}
    }
}
