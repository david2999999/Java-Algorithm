public class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentValue = arr[i];

            int walk = i - 1;
            while (walk >= 0 && arr[walk] > currentValue) {
                arr[walk + 1] = arr[walk];
                --walk;
            }

            arr[walk + 1] = currentValue;
        }
    }
}