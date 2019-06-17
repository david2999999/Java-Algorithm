package SortingAndSearching;

// given an array list data structure Listy which lacks a size method
// it does have an elementAt(i) method that returns the element at index i, in O(1) time
// if i is beyond the bounds of the data structure, it return -1
// given a Listy which contains sorted, positive integers, find the index at which an element occurs
public class SortedSearch {
    // this is just an example class for this problem, not an actual implementation
    private static class Listy {
        public int elementAt(int i) {
            return Integer.MAX_VALUE;
        }
    }

    // this example uses the binary search because of the sorted list
    // but we have to find the start and high index for the binary search
    public int search(Listy list, int value) {
        int index = 1;  // start with index 1

        // while the value at the index is not out of bound
        // and also the value at that index is less than the value that we are searching for
        while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
            index *= 2; // increasing in multiples of 2, this will make the run time to O(log n)
        }

        // does a binary search using index as the highest index
        // and index / 2 as the lower index
        // this is because we search until list.elementAt(index) < value, index / 2 is lower than the
        // value we are looking for
        return binarySearch(list, value, index / 2, index);
    }

    private int binarySearch(Listy list, int value, int low, int high) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2; // the middle index
            int middle = list.elementAt(mid);   // the value at the middle index

            // if the middle value is greater than the value we are searching for, we have to search left side
            // if the middle value is -1, we are still index out of bound, search the lower side (left side)
            if (middle > value || middle == -1) {
                high = mid - 1;
            } else if (middle < value) {    // if the middle value is lower than the value we are searching for
                low = mid + 1;  // search the right side
            } else {
                return mid; // we have found the index of the value that we are searching for
            }
        }

        return -1;  // did not find the index of the value
    }
}













