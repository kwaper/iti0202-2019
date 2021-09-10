package ee.taltech.iti0202.files.morse;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseTranslator {

    private String morseAlpha = "A .-\n"
            + "B -...\n"
            + "C -.-.\n"
            + "D -..\n"
            + "E .\n"
            + "F ..-.\n"
            + "G --.\n"
            + "H ....\n"
            + "I ..\n"
            + "J .---\n"
            + "K -.-\n"
            + "L .-..\n"
            + "M --\n"
            + "N -.\n"
            + "O ---\n"
            + "P .--.\n"
            + "Q --.-\n"
            + "R .-.\n"
            + "S ...\n"
            + "T -\n"
            + "U ..-\n"
            + "V ...-\n"
            + "W .--\n"
            + "Ä .-.-\n"
            + "Ö ---.\n"
            + "Ü ..--\n"
            + "X -..-\n"
            + "Y -.--\n"
            + "Z --..\n"
            + "0 -----\n"
            + "1 .----\n"
            + "2 ..---\n"
            + "3 ...--\n"
            + "4 ....-\n"
            + "5 .....\n"
            + "6 -....\n"
            + "7 --...\n"
            + "8 ---..\n"
            + "9 ----.\n"
            + "& .-...\n"
            + "' .----.\n"
            + "@ .--.-.\n"
            + ") -.--.-\n"
            + "( -.--.\n"
            + ": ---...\n"
            + ", --..--\n"
            + "= -...-\n"
            + "! -.-.--\n"
            + ". .-.-.-\n"
            + "- -....-\n"
            + "+ .-.-.\n"
            + "\" .-..-.\n"
            + "? ..--..\n"
            + "/ -..-.";

    private ArrayList<String> morsee = new ArrayList<String>();

    private Map<String, String> morseMapAlpha = new HashMap<>();

    private Map<String, String> morseMapMorse = new HashMap<>();


    public Map<String, String> getMorse() {
        boolean xx = Collections.addAll(morsee, morseAlpha.split("\\s"));
        for (int i = 0; i < morsee.size() - 1; i += 2) {
            this.morseMapAlpha.putIfAbsent(morsee.get(i).toLowerCase(), morsee.get(i + 1));
            this.morseMapMorse.putIfAbsent(morsee.get(i + 1), morsee.get(i).toLowerCase());
        }
        return this.morseMapAlpha;
    }

    public Map<String, String> addMorseCodes(List<String> lines) {
        getMorse();
        Map<String, String> linesToMorse = new HashMap<>();
        List<String> linesString = new ArrayList<>();
        if (!lines.isEmpty()) {
            boolean getLines = Collections.addAll(linesString, String.join("", lines).toLowerCase().split(""));
            for (String x : linesString) {
                linesToMorse.putIfAbsent(x, this.morseMapAlpha.get(x));
            }
        }
        return linesToMorse;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        getMorse();
        List<String> linesTranslateToMorse = new ArrayList<>();
        if (lines != null) {
            for (String x : lines) {
                if (x != null) {
                    linesTranslateToMorse.add(translateLineToMorse(x));
                }
            }
        }

        return linesTranslateToMorse;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        getMorse();
        List<String> linesTranslateFromMorse = new ArrayList<>();
        if (lines != null) {
            for (String x : lines) {
                if (x != null) {
                    linesTranslateFromMorse.add(translateLineFromMorse(x));
                }
            }
        }
        return linesTranslateFromMorse;

    }

    private String translateLineToMorse(String line) {
        getMorse();
        String toAdd = "";
        String[] splitted = line.split("");
        for (int i = 0; i < line.length() - 1; i++) {
            if (!splitted[i].equals(" ") && splitted[i + 1].equals(" ")) {
                toAdd += morseMapAlpha.get(splitted[i].toLowerCase());
            } else if (!splitted[i].equals(" ") && !splitted[i + 1].equals(" ")) {
                toAdd += morseMapAlpha.get(splitted[i].toLowerCase()) + " ";
            } else toAdd += "\t";
        }
        if (splitted.length > 1) {
            toAdd += morseMapAlpha.getOrDefault(splitted[splitted.length - 1].toLowerCase(), "\t");
        }
        return toAdd;
    }

    private String translateLineFromMorse(String line) {
        getMorse();
        String sentence = "";
        String[] splitted = line.split("\\t");
        for (String m : splitted) {
            String[] splittedSpace = m.split(" ");
            String word = "";
            for (int w = 0; w < splittedSpace.length; w++) {
                word += morseMapMorse.getOrDefault(splittedSpace[w], "");
            }
            if (sentence.length() == 0) {
                sentence += word;
            } else sentence += " " + word;

        }
        return sentence;
    }
}
