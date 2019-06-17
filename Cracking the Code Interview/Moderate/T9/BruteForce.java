package Moderate.T9;

import java.util.ArrayList;
import java.util.HashSet;

public class BruteForce {

    private void getValidWords(String number, int index, String prefix,
                               HashSet<String> wordSet, ArrayList<String> results) {
        if (index == number.length() && wordSet.contains(prefix)) {
            results.add(prefix);
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char c: letters) {
                getValidWords(number, index + 1, prefix + c, wordSet, results);
            }
        }
    }


    private char[][] t9Letters = {null, null, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
            {'m','n','o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w','x','y','z'}};

    private char[] getT9Chars(char digit) {
        if (!Character.isDigit(digit)) return null;

        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');

        return t9Letters[dig];
    }
}
