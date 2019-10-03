package Moderate.T9;

// On old cell phones, users typed on a numeric keypad and the phone would provide a list of words
// that matched these numbers. Each digit mapped to a set of 0 - 4 letters. Implement an algorithm to return
// a list of matching words, given a sequence of digits.

// 1 ->
// 2 -> abc, 3 -> def, 4 -> ghi
// 5 -> jkl, 6 -> mno, 7 -> pqrs, 8 -> tuv
// 9 -> wxyz
// 0 ->


import java.util.ArrayList;
import java.util.HashSet;

// Input: 8733
// Output: tree, used
public class BruteForce {
    // number 0 and 1 does not contain any characters
    private char[][] t9Letters = {
            null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public ArrayList<String> getValidT9Words(String number, HashSet<String> wordList) {
        // all of the valid words that can be generated from the number
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", wordList, results);
        return results; // return all of the valid words generated from the number
    }

    private void getValidWords(String number, int index, String prefix, HashSet<String> wordSet,
                               ArrayList<String> results) {
        // if we have no more numbers to check
        // and the wordset contains the word
        if (index == number.length() && wordSet.contains(prefix)) {
            results.add(prefix);    // add the valid word to the result
            return;
        }

        char digit = number.charAt(index);
        char[] letters = getT9Chars(digit);

        if (letters != null) {
            for (char letter: letters) {
                // increment the index of the current word
                // add the letter to the current word
                // this is used to find all possible combinations
                getValidWords(number, index + 1, prefix + letter, wordSet, results);
            }
        }
    }

    private char[] getT9Chars(char digit) {
        // if the input is not a digit
        if (!Character.isDigit(digit)) {
            return null;
        }

        // get the integer representation of the digit to 0 - 9
        int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
        return t9Letters[dig];
    }


}





















