public class InsertionSort {
    public static void sort(char[] data) {
        int n = data.length;

        for (int k = 1; k < n; k++) {
            char cur = data[k];
            int j = k;

            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
            }

            data[j] = cur;
        }
    }
}

//We note that if an array is already sorted, the inner loop of insertion-sort does
//only one comparison, determines that there is no swap needed, and returns back
//to the outer loop. Of course, we might have to do a lot more work than this if the
//input array is extremely out of order. In fact, we will have to do the most work if
//the input array is in decreasing order.