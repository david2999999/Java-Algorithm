public class ReverseIteratively {
    public static void reverse(int[] data) {
        int low = 0, high = data.length - 1;

        while (low < high) {
            int temp = data[low];
            data[low++] = data[high];
            data[high--] = temp;
        }
    }
}