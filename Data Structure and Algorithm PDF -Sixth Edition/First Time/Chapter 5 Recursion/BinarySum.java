public class BinarySum {
    public static int sum(int[] data, int low, int high) {
        if (low > high)
            return 0;
        else if (low == high) 
            return data[low];
        else {
            int mid = (low + high) / 2;
            return sum(data, low, mid) + sum(data, mid + 1, high);
        }
    }
}