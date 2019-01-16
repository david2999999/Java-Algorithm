public class ReverseArray {
    public static void reverse(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverse(data, low + 1, high - 1);
        }
    }

}