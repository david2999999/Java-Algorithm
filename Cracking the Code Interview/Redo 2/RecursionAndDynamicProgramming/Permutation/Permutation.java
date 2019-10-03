package RecursionAndDynamicProgramming.Permutation;

import java.util.ArrayList;

// write a method to compute all permutations of a string of unique characters
public class Permutation {
    // we have to build characters from the first n - 1 character
    // for example
    // P(a1) = a1
    // P(a1a2) = a1a2, a2a1
    // p(a1a2a3) = a1a2a3, a1a3a2, a2a1a3, a2a3a1, a3a1a2, a3a2a1
    // basically inserting the new character at every single location of the previous permutation

    public ArrayList<String> getPerms(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();

        if (str.length() == 0) {    // base case
            permutations.add("");   // this is P()
            return permutations;
        }

        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1);    // remove the first char
        // get all of the permutations which does not include first character
        ArrayList<String> words = getPerms(remainder);

        for (String word: words) {  // loop through all the permutations
            for (int j = 0; j <= word.length(); j++) {
                String s = insertChatAt(word, first, j);
                permutations.add(s);    // add the new permutation
            }
        }

        return permutations;    // return the permutations which includes the current first character
    }

    // insert the character in a specific index
    private String insertChatAt(String word, char c, int i) {
        String start = word.substring(0, i);    // first half of the word
        String end = word.substring(i); // second half of the word
        // insert the character between the two halves,
        // Note: the character may be inserted in the front or in the back of the word
        // if the start or the end is an empty string
        return start + c + end;
    }
}
















