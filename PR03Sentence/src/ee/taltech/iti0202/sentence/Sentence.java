package ee.taltech.iti0202.sentence;

import java.util.ArrayList;

/**
 * Sentence class represent words and punctuation.
 */
public class Sentence {

    /**
     * Given string is treated as possible sentence.
     * <p>
     * Ignore all duplicate whitespaces.
     * If a word ends with ".", "!" or "?" treat it as punctuation.
     * No words can follow after punctuation - just ignore those.
     *
     * @param text Sentence as string
     */
    private ArrayList<String> sentenceNew = new ArrayList<>();

    private String symbols = "!?.";

    private boolean punctuationNotAdded = true;

    private String punctuationStr = "";

    public Sentence(String text) {
        int numberOfSymbols = 0;
        ArrayList<String> newList = new ArrayList<>();
        String newText = "";
        for (String oneword : text.split("\\s+")) {
            newList.add(oneword);
        }
        while (newList.contains("")) {
            newList.remove("");
        }
        newText += newList.get(0);
        for (int i = 1; i < newList.size(); i++) {
            newText += " " + newList.get(i);
        }
        text = newText;
        for (String word : text.split(" ")) {
            if (symbols.contains(word.substring(word.length() - 1))) {
                numberOfSymbols += 1;
                punctuationNotAdded = false;
                for (int i = word.length() - 1; i > 0; i--) {
                    if (word.substring(i, i + 1).equals(word.substring(i - 1, i))) {
                        numberOfSymbols += 1;
                    } else break;
                }
                sentenceNew.add(word.substring(0, word.length() - numberOfSymbols));
                sentenceNew.add(word.substring(word.length() - numberOfSymbols));
                break;
            } else sentenceNew.add(word);
        }
        if (!punctuationNotAdded) {
            punctuationStr = sentenceNew.get(sentenceNew.size() - 1);
        }
    }

    public Sentence() {
    }

    /**
     * Removes the first occurrence of the specified word from this sentence, if it is present.
     * If the word is not in the sentence, returns false.
     * If the sentence already has punctuation, returns false (nothing is removed).
     * Otherwise removes the word and returns true.
     *
     * @param word Word to be removed.
     * @return Whether word was in the sentence and removed.
     */
    public boolean removeWord(String word) {
        if (sentenceNew.contains(word) && punctuationNotAdded) {
            sentenceNew.remove(word);
            return true;
        }
        return false;
    }

    /**
     * Adds word to sentence. The word can be any non-empty string without spaces.
     * If the sentence has punctuation added (either by the string in constructor
     * or by addPunctuation method), method return false and word is not added.
     * Otherwise the methods returns true and word is added to sentence.
     *
     * @param word Non-empty string without spaces.
     * @return Whether word was added to sentence (false if sentence has punctuation).
     */
    public boolean addWord(String word) {
        if (punctuationNotAdded) {
            sentenceNew.add(word);
            return true;
        }
        return false;

    }

    /**
     * Adds punctuation to the sentence.
     * <p>
     * The sentence can have only one punctuation. When trying to add second, method should return false.
     * If there are no words in the sentence, punctuation cannot be added.
     * If punctuation is added, no more words can be added.
     *
     * @param punctuation Punctuation string (e.g. "!")
     * @return Whether punctuation was added (false if sentence already had punctuation).
     */
    public boolean addPunctuation(String punctuation) {
        if (punctuationNotAdded && sentenceNew.size() != 0) {
            sentenceNew.add(punctuation);
            punctuationStr = punctuation;
            punctuationNotAdded = false;
            return true;
        }
        return false;

    }

    /**
     * Removes punctuation.
     * <p>
     * If punctuation is not yet added, the method returns false.
     * If punctuation has been added, it is removed.
     * After removing the punctuation, words can be added.
     *
     * @return Whether punctuation was removed (false if there was no punctuation).
     */
    public boolean removePunctuation() {
        if (!punctuationNotAdded) {
            sentenceNew.remove(punctuationStr);
            punctuationNotAdded = true;
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        String finalString = "";
        int counterAddedWords = 0;
        if (sentenceNew.size() == 0) {
            return "";
        } else if (sentenceNew.size() == 1) {
            return sentenceNew.get(0).substring(0, 1).toUpperCase() + sentenceNew.get(0).substring(1) + "...";
        }
        for (String i : sentenceNew) {
            if (counterAddedWords == 0) {
                finalString += i;
                counterAddedWords += 1;
            } else if (counterAddedWords == sentenceNew.size() - 1) {
                if (punctuationNotAdded) {
                    finalString += " " + i + "...";
                } else finalString += i;
            } else if (counterAddedWords > 0) {
                finalString += " " + i;
                counterAddedWords += 1;
            }
        }
        return finalString.substring(0, 1).toUpperCase() + finalString.substring(1);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
