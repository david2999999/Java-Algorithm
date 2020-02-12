public class InsertionSort {
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int current = a[i], j;

            for (j = i; j > 0 && a[j - 1] > current; j--) {
                a[j] = a[j - 1];
            }

            a[j] = current;
        }
    }
}

// If implemented well, the running time of insertion-sort is O(n+m), where m is
//the number of inversions (that is, the number of pairs of elements out of order).
//Thus, insertion-sort is an excellent algorithm for sorting small sequences (say, less
//than 50 elements), because insertion-sort is simple to program, and small sequences
//necessarily have few inversions. Also, insertion-sort is quite effective for sorting
//sequences that are already “almost” sorted. By “almost,” we mean that the number
//of inversions is small. But the O(n2)-time performance of insertion-sort makes it a
//poor choice outside of these special contexts.