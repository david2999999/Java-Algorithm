public class BinarySearch {
    public static boolean search(int[] data, int target, int low, int high) {
        if (low > high) return false;
        
        int mid = (low + high) / 2;
        if (target == data[mid]) 
            return true;
        else if (target < data[mid])
            return search(data, target, low, mid - 1);
        else 
            return search(data, target, mid + 1, high);
    }
}