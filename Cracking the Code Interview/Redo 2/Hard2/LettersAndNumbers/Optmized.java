package Hard2.LettersAndNumbers;

import java.util.HashMap;

// Given an array filled with letters and numbers, find the longest sub array with
// an equal number of letters and numbers
public class Optmized {
    // extract the values from the array
    private char[] extractSubarray(char[] array, int start, int end) {
        char[] subarray = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            subarray[i - start] = array[i];
        }

        return subarray;
    }

    // in the optimized version, we have to find the difference in count of the letters and numbers at
    // each of the indices. When there are two deltas that are equal at different indices, then we know
    // there are a same number of occurrences of letters and numbers.
    public char[] findLongestSubarray(char[] array) {
        // compute difference or delta between count of numbers and count of letters
        int[] deltas = computeDeltaArray(array);

        // find pair in deltas with matching values and longest length
        int[] match = findLongestMatch(deltas);

        // extract the subarray
        return extractSubarray(array, match[0] + 1, match[1]);
    }

    private int[] findLongestMatch(int[] deltas) {
        HashMap<Integer, Integer> map = new HashMap<>();    // keeps track of delta and its index
        // the delta is 0, before we start traversing the array
        map.put(0, -1);
        int[] max = new int[2]; // keeps track of the indexes of longest length

        for (int i = 0; i < deltas.length; i++) {
            if (!map.containsKey(deltas[i])) {  // if the map does not contain the delta yet
                map.put(deltas[i], i);  // put the delta and its position in the map
            } else {
                int match = map.get(deltas[i]); // get the position of the matched delta
                int distance = i - match;   // calculating the distance of the two indices
                int longest = max[1] - max[0];  // the longest distance
                if (distance > longest) {   // if the current distance is greater than the longest
                    // update the 2 indices
                    max[1] = i;
                    max[0] = match;
                }
            }
        }

        return max;
    }

    private int[] computeDeltaArray(char[] array) {
        int[] deltas = new int[array.length];
        int delta = 0;  // keeping track of the differences

        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) { // if it is a letter
                delta++;
            } else {    // it is a number
                delta--;
            }

            deltas[i] = delta;  // store the delta at the index
        }

        return deltas;
    }

}









