package Redo.Moderate.T9;

import CodeLibrary.HashMapList;

import java.util.ArrayList;
import java.util.HashMap;

public class OptimizedWithHashmapList {
    private char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private ArrayList<String> getT9String(String number, HashMapList<String, String> dictionary) {
        return dictionary.get(number);
    }

    private HashMapList<String, String> generateDictionary(String[] words) {
        if (words.length == 0) return null;

        HashMap<Character, Character> letterToDigitMap = generateLetterToDigitMap();
        HashMapList<String, String> dictionary = new HashMapList<>();

        for (String word: words) {
            String t9String = convertToT9String(word, letterToDigitMap);
            dictionary.put(t9String, word);
        }

        return dictionary;
    }

    private HashMap<Character, Character> generateLetterToDigitMap() {

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];

            if (letters != null) {
                for (char letter: letters) {
                    char c = Character.forDigit(i, 10);
                    map.put(letter, c);
                }
            }
        }

        return map;
    }

    private String convertToT9String(String word, HashMap<Character, Character> letterToDigitMap) {
        StringBuilder sb = new StringBuilder();

        for (char c: word.toCharArray()) {
            if (letterToDigitMap.containsKey(c)) {
                sb.append(letterToDigitMap.get(c));
            }
        }

        return sb.toString();
    }
}
