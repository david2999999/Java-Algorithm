package Moderate.T9;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;

public class Optimized {
    private ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
        return dictionary.get(numbers);
    }

    private HashMapList<String, String> initializeDictionary(String[] words) {
        HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();

        HashMapList<String, String> wordsToNumber = new HashMapList<>();
        for (String word: words) {
            String numbers = convertToT9(word, letterToNumberMap);
            wordsToNumber.put(numbers, word);
        }

        return wordsToNumber;
    }

    private HashMap<Character, Character> createLetterToNumberMap() {
        HashMap<Character, Character> letterToNumberMap = new HashMap<>();

        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];

            if (letters != null) {
                for (char letter: letters) {
                    char c = Character.forDigit(i, 10);
                    letterToNumberMap.put(letter, c);
                }
            }
        }

        return letterToNumberMap;
    }

    private String convertToT9(String word, HashMap<Character, Character> letterToNumberMap) {
        StringBuilder sb = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (letterToNumberMap.containsKey(c)) {
                char digit = letterToNumberMap.get(c);
                sb.append(digit);
            }
        }

        return sb.toString();
    }

    private char[][] t9Letters = {null, null, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
            {'m','n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w','x','y','z'}};
}
