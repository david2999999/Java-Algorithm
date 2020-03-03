public class SparseSearch {
    public int search(String[] strings, String str) {
        if (strings == null || str == null || str.isEmpty()) {
            return -1;
        }

        return search(strings, str, 0, strings.length - 1);
    }

    public int search(String[] strings, String str, int first, int last) {
        if (first > last) {
            return -1;
        }

        int mid = findNonEmptyIndex(strings, first, last);

        if (mid == -1) {
            return -1;
        } else if (strings[mid].equals(str)) {
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            return search(strings, str, mid + 1, last);
        } else {
            return search(strings, str, first, mid - 1);
        }
    }

    private int findNonEmptyIndex(String[] strings, int first, int last) {
        int mid = (first + last) / 2;

        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    return right;
                } else if (left >= first && !strings[left].isEmpty()) {
                    return left;
                }

                left--;
                right++;
            }
        }

        return mid;
    }
}