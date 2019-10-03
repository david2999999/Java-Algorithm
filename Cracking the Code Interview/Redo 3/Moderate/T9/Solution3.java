package Moderate.T9;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3 {
    private char[][] t9Letters = {
            null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public ArrayList<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
        return dictionary.get(numbers);
    }

    public HashMapList<String, String> initializeDictionary(String[] words) {
        HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();

        HashMapList<String, String> wordsToNumbers = new HashMapList<>();
        for (String word: words) {
            String numbers = convertToT9(word, letterToNumberMap);
            wordsToNumbers.put(numbers, word);
        }

        return wordsToNumbers;
    }

    private String convertToT9(String word, HashMap<Character,Character> letterToNumberMap) {
        StringBuilder sb = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (letterToNumberMap.containsKey(c)) {
                char digit = letterToNumberMap.get(c);
                sb.append(digit);
            }
        }

        return sb.toString();
    }

    private HashMap<Character,Character> createLetterToNumberMap() {
        HashMap<Character, Character> lettersToNumberMap = new HashMap<>();

        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];
            if (letters != null) {
                for (char letter: letters) {
                    char c = Character.forDigit(i, 10);
                    lettersToNumberMap.put(letter, c);
                }
            }
        }

        return lettersToNumberMap;
    }
}













