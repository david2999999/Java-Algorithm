package RecursionAndDynamicProgramming.MagicIndex;

// a magic index in an array A[1 ... n -1] is defined to be an index such that A[i] = i.
// Given a sorted array of distinct integers, write a method to find a magic index, if one exist, in array A
public class MagicIndex {
    // the brute force solution can be just iterating through the whole array and finding that index
    public int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {    // found the magic index
                return i;
            }
        }

        return -1;  // did not find the magic index
    }

    // there is a quicker way to find the magic number using binary search, since the array is originally sorted
    // this method currently works for array of distinct values
    public int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private int magicFast(int[] array, int start, int end) {
        if (end < start) {  // did not find the magic index
            return -1;
        }

        int mid = (start + end) / 2;    // middle index
        if (array[mid] == mid) {
            return mid; // found magic index
        } else if (array[mid] > mid) {  // got to search the left side
            return magicFast(array, start, mid - 1);
        } else {    // got to search the right side
            return magicFast(array, mid + 1, end);
        }
    }

    // the next example will also use binary search, but will handle array with duplicate values
    public int magicFast2(int[] array) {
        return magicFast2(array, 0, array.length - 1);
    }

    // since there can be duplicate values, we have to search both the right side and left side
    // of the array
    private int magicFast2(int[] array, int start, int end) {
        if (end < start) {  // did not find the magic index
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex]; // get the value of the current mid index

        if (midIndex == midValue) {
            return midIndex;    // found the magic value
        }

        // search the left side first
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) {
            return left;    // found magic index, if left is -1, then no magic index on left side
        }

        // search the right side
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);

        return right;   // can be the magic index or can be -1
    }
}

















