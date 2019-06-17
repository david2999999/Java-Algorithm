package Moderate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// design an algorithm to find all pairs of integers
// within an array which sum to a specific value
public class PairWithSum {
    private static class Pair {
        private int num1;
        private int num2;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }
    }

    // the brute force approach is to loop through the array
    // with 2 for loops and check for the pair
    // note: this method may produce duplicate pairs if the array is like {5, 6, 5}
    public ArrayList<Pair> printPairSumBruteForce(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {   // we have found the pair
                    result.add(new Pair(array[i], array[j]));
                }
            }
        }
        return result;
    }

    // an optimized solution is to use a data structure to store the complement of each number
    public ArrayList<Pair> printPairSumsOptimized(int[] array, int sum) {
        ArrayList<Pair> result = new ArrayList<>();
        // stores the complement and the occurrences of the complement
        HashMap<Integer, Integer> unpairedCount = new HashMap<>();

        for (int x: array) {
            int complement = sum - x;   // complement is the number we need to pair up with x
            if (unpairedCount.getOrDefault(complement, 0) > 0) {    // if we have an unpaired complement
                result.add(new Pair(x, complement));
                adjustCounterBy(unpairedCount, complement, -1); // reduce the unpaired count by 1
            } else {    // do not have an complement in the HashMap
                adjustCounterBy(unpairedCount, x, 1);   // increase the occurrence of x by 1
            }
        }

        return result;  // all of the pairs
    }

    private void adjustCounterBy(HashMap<Integer,Integer> counter, int key, int delta) {
        counter.put(key, counter.getOrDefault(key, 0) + delta);
    }

    // an alternative optimized solution is use sorting, then find the pair
    public void printPairSum(int[] array, int sum) {
        Arrays.sort(array);
        int first = 0;  // search from the beginning
        int last = array.length - 1;    // search from the end
        while (first < last) {
            int s = array[first] + array[last]; // the smallest element + largest element
            if (s == sum) { // found the pair
                System.out.println(array[first] + " " + array[last]);

                // adjust to find the next pair
                first++;
                last--;
            } else {
                if (s < sum) {  // the current sum is too small, we need to move the first pointer
                    first++;
                } else {    // the current sum is too large, we need to move the last pointer
                    last--;
                }
            }
        }
    }
}




















