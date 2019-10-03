package SortingAndSearching;

// give two sorted arrays, A and B, where A has a large enough buffer at the
// end to hold B. Write a method to merge B into A in sorted order
public class SortedMerge {

    public void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1; // index of the last element in array A
        int indexB = lastB - 1; // index of the last element in array B
        int indexMerged = lastB + lastA - 1;    // end of the merged array

        // merging A and B, starting from the last element of each
        while (indexB >= 0) {   // while there is still element in B to merge into array A
            // if there are still element in array A and also if the current element in A
            // is greater than the current element in B
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; // copy the element to the merged index
                indexA--;   // moving down to the next value of A
            } else {
                a[indexMerged] = a[indexB]; // copy the element from B to the merged index
                indexB--;
            }

            indexMerged--;  // after an element is inserted to the end index of the merged array
                            // subtract 1 to continue to the next element to be inserted
        }
    }
}
