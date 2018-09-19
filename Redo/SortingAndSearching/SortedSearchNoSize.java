package Redo.SortingAndSearching;

public class SortedSearchNoSize {
    private int search(Listy listy, int value) {
        int index = 1;

        while (listy.elementAt(index) != -1 && listy.elementAt(index) < value) {
            index *= 2;
        }

        return findValue(listy, value, index / 2, index);
    }

    private int findValue(Listy listy, int value, int left, int right) {
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            int midValue = listy.elementAt(mid);
            if (midValue > value || midValue == -1) {
                right = mid - 1;
            } else if (midValue < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private class Listy {
        int value;


        public int elementAt(int x) {
            return value;
        }
    }
}
