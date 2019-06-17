package Redo.SortingAndSearching;

public class SparseSearch {
    private int search(String[] arr, String word) {
        if (arr == null || word == null || word.equals("")) return -1;

        return search(arr, word, 0, arr.length - 1);
    }

    private int search(String[] arr, String word, int low, int high) {
        if (low < high) return -1;

        int mid = (low + high) / 2;

        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < low && right > high) {
                    return -1;
                } else if (left >= low && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                } else if (right <= high && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }

                left--;
                right++;
            }
        }

        if (arr[mid].equals(word)) {
            return mid;
        } else if (arr[mid].compareTo(word) < 0) {
            return search(arr, word, mid + 1, high);
        } else {
            return search(arr, word, low, mid - 1);
        }
    }
}
