package Moderate;

import java.util.HashMap;

// design a method to find the frequency of occurrences of any given word
// in a book, what if we running this algorithm multiple times?
public class WordFrequency {
    // if we are only looking for the frequency of one word, we can just iterate through the book once
    public int getFrequence(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;  // keeping a counter of how many times the word appears

        for (String w: book) {
            if (w.trim().toLowerCase().equals(word)) {  /// if we found an occurrence
                count++;
            }
        }

        return count;   // return the total number of occurrence
    }

    // if we are going to perform the lookup multiple time, we will want to store the word
    // and its frequency in an HashMap, then the lookup time for each word from the HashMap will be O(1)
    public HashMap<String, Integer> setupDictionary(String[] book) {
        HashMap<String, Integer> table = new HashMap<>();

        for (String word: book) {
            word = word.toLowerCase();
            if (!word.trim().equals("")) {  // if the word does not equal ""
                if (!table.containsKey(word)) { // if the HashMap does not contain the word yet
                    table.put(word, 0); // put the word into the HashMap
                }
                table.put(word, table.get(word) + 1);   // increment the occurrence of the word
            }
        }

        return table;   // return the HashMap with the all the words and each of their occurrences
    }

    public int getFrequence(HashMap<String, Integer> table, String word) {
        if (table == null || word == null) return -1;   // invalid params

        word = word.toLowerCase();
        if (table.containsKey(word)) {  // if the HashMap does contain the word
            return table.get(word); // return the number of occurrences of the word in the book
        }

        return 0;   // no occurrence because we can't find it in the HashMap
    }
}


















