public class BinarySearchIterative {
    public static boolean search(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == data[mid]) 
                return true;
            else if (target < data[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
    }
}