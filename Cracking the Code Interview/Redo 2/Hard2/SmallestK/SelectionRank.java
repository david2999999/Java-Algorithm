package Hard2.SmallestK;

import java.util.Random;

// Design an algorithm to find the smallest K numbers in an array
public class SelectionRank {
    // this example will use selection rank to find the i th smallest or largest integer in linear time
    // then we will use this integer to find the smallest K numbers
    public int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {   // invalid k value
            throw new IllegalArgumentException();
        }

        int threshold = rank(array, k - 1); // finding the i th largest element
        int[] smallest = new int[k];    // the smallest k elements
        int count = 0;
        for (int a : array) {
            // since threshold is the kth largest element
            // any element that is smaller or equal to the threshold should be added to the smallest array
            if (a <= threshold) {
                smallest[count] = a;
                count++;
            }
        }

        return smallest;    // return the smallest k numbers
    }

    private int rank(int[] array, int rank) {
        return rank(array, 0, array.length - 1, rank); // recursively find the rank
    }

    private int rank(int[] array, int left, int right, int rank) {
        int pivot = array[randomIntInRange(left, right)];   // get a random number from the array as pivot
        int leftEnd = partition(array, left, right, pivot); // finding the left most index
        int leftSize = leftEnd - left + 1;  // the size of the left array

        if (rank == leftSize - 1) { // found the size we need
            return max(array, left, leftEnd);   // find the maximum element on the left size
        } else if (rank < leftSize) {   // if the rank is smaller than the left size
            return rank(array, left, leftEnd, rank);    // search the left size for the rank
        } else {
            // search the right side for the rank
            return rank(array, leftEnd + 1, right, rank - leftSize);
        }
    }

    // find the maximum element in the interval
    private int max(int[] array, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(array[i], max);
        }

        return max;
    }

    // partition the array around the pivot such that all elements <= pivot comes before all
    // elements > pivot
    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            if (array[left] > pivot) {  // if the element in the left is greater
                // swap the left element with the element at the right
                swap(array, left, right);
                right--;    // right index is populated, subtract 1
            } else if (array[right] <= pivot) { // if the element in the right is less than or equal to the pivot
                // swap the left element with the element at the right, since right is smaller
                // swap it to the left
                swap(array, left, right);
                left++;
            } else {
                left++;
                right--;
            }
        }

        return left - 1;    // return the index where all the index on the left is smaller than the pivot
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // generate random integer within range min -> max inclusive
    private int randomIntInRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max + 1 - min) + min;
    }

}
