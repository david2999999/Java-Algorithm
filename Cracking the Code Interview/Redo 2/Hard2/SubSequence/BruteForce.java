package Hard2.SubSequence;

// Given two arrays, 1 small array (with distinct elements) and 1 large array.
// Find the shortest subarray in the long array that contains all the elements
// in the shorter array
public class BruteForce {
    // in this brute for approach we will go through every index of the large array
    // to find the shortest subarray that contains all the elements inside the smaller array
    // first, we need to create a range class to hold the start and end of the subarray
    public Range shortestSupersequence(int[] bigArray, int[] smallArray) {
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < bigArray.length; i++) {
            // finding the end index which create a subarray that contains all of the elements in small array
            int end = findClosure(bigArray, smallArray, i);
            if (end == -1) {    // can not find the end index anymore, break out of the for loop
                break;
            }

            // if there is a smaller subarray
            if (bestStart == -1 || end - i < bestEnd - bestStart) {
                bestStart = i;
                bestEnd = end;
            }
        }

        // return the shortest subarray range
        return new Range(bestStart, bestEnd);
    }

    private int findClosure(int[] bigArray, int[] smallArray, int index) {
        int max = -1;
        // looping through the small array to make sure we find all the elements we need
        for (int i = 0; i < smallArray.length; i++) {
            // find the index which contains the current element
            int next = findNextInstance(bigArray, smallArray[i], index);
            if (next == -1) {   // we can not find the element inside the big array
                return -1;      // we can not find the end index which contains all the elements of small array
            }

            max = Math.max(next, max);  // get the furthest index
        }

        // the max index which contains all of the elements of the small array
        // index -> max
        return max;
    }

    private int findNextInstance(int[] array, int element, int index) {
        for (int i = index; i < array.length; i++) {
            if (array[i] == element) {  // we have found the element we need
                return i;   // return the index
            }
        }

        return -1;  // did not find the element
    }
}










