package Redo.Moderate.T9;

import java.util.ArrayList;
import java.util.HashSet;

public class BruteForce {
    private char[][] t9Letters = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
        ArrayList<String> result = new ArrayList<>();
        getValidWords(number, 0, "", wordList, result);
        return result;

    }

    private void getValidWords(String number, int index, String prefix, HashSet<String> wordList, ArrayList<String> result) {
        if (index == number.length() && wordList.contains(prefix)) {
            result.add(prefix);
        }

        char digit = number.charAt(index);
        char[] letters = getT9Letter(digit);

        if (letters != null) {
            for (char c: letters) {
                getValidWords(number, index + 1, prefix + c, wordList, result);
            }
        }
    }

    private char[] getT9Letter(char digit) {
        if (Character.isDigit(digit)) return null;

        int index = Character.getNumericValue(digit) - Character.getNumericValue('0');

        return t9Letters[index];
    }


}
