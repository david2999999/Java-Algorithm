package SortingAndSearching;

// given a sorted array of strings that is interspersed with empty strings
// write a method to find the location of a given string
// Ex: {"at" , "", "", "", "elephant", "", "", "giraffe", "", "" , "", "", "zebra" }
public class SparseSearch {
    // since the array is sorted, we can perform a binary search for the string
    // but we have to modify the binary search to fit our need
    // if the value at the mid index is an empty string, we have to find the nearest index without an empty string

    public int search(String[] strings, String str, int first, int last) {
        if (first > last) { // invalid, can't find the string
            return -1;
        }

        int mid = (first + last) / 2;   // get the middle index

        if (strings[mid].isEmpty()) {   // if the value in the middle index is an empty string
            // find the nearest non empty string
            int left = mid - 1;
            int right = mid + 1;

            while (true) {
                if (left < first && right > last) { // index out of bound, can't find the string
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    // if the right index is not index out of bound and is not empty
                    mid = right;    // set the mid index to the right index
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    // if the left index is not index out of bound and is not empty
                    mid = left; // set the mid index to the left index
                    break;
                }

                right++;    // shift an index to the right
                left--;     // shift an index to the left
            }
        }

        if (str.equals(strings[mid])) { // found the string!
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            // if the value at the middle index is smaller than the string we are searching for
            return search(strings, str, mid + 1, last); // search the right side
        } else { // if the value at the middle index is greater than the string we are searching for
            return search(strings, str, first, mid - 1);    // search the left side
        }
    }

    // the method to invoke the recursive binary search
    public int seach(String[] strings, String str) {
        // checking if the strings and str is valid
        if (strings == null || str == null || str.equals("")) {
            return -1;
        }

        // recursive binary search call
        return search(strings, str, 0, strings.length - 1);
    }
}













