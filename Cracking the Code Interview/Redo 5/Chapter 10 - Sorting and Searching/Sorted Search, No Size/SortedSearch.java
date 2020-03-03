public class SortedSearch {
    public int search(Listy list, int value) {
       int rightIndex = 1;

       while (list.elementAt(rightIndex) != -1 || list.elementAt(rightIndex) < value) {
           rightIndex *= 2;
       }

        return binarySearch(list, rightIndex / 2, rightIndex, value);
    }

    private int binarySearch(Listy list, int low, int high, int value) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.elementAt(mid) == -1 || list.elementAt(mid) > value) {
                low = mid - 1;
            } else if (list.elementAt(mid) < value) {
                high = mid + 1;
            } else {
                return mid;
            }
        }

        return  -1;
    }
}