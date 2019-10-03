package Moderate.WordFrequency;

public class Solution1 {
    public int getFrequency(String[] book, String word) {
        word = word.trim().toLowerCase();

        int count = 0;
        for (String w: book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }

        return count;
    }
}
