package Hard2.LettersAndNumbers;

// Given an array filled with letters and numbers, find the longest sub array with
// an equal number of letters and numbers
public class BruteForce {
    // the brute force method is to loop through the array and find the sub array
    public char[] findLongestSubarray(char[] array) {
        for (int len = array.length; len > 1; len--) {  // start from the end of array
            for (int i = 0; i <= array.length - len; i++) { // start from the beginning of the array
                if (hasEqualsLettersNumbers(array, i, i + len - 1)) {   // if there are equal letter and num
                    return extractSubarray(array, i, i + len - 1);  // extract the sub array
                }
            }
        }

        return null;    // did not find the longest sub array
    }

    private char[] extractSubarray(char[] array, int start, int end) {
        char[] subarray = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            subarray[i - start] = array[i];
        }

        return subarray;
    }

    // checking if there are the same letters and numbers in the interval
    private boolean hasEqualsLettersNumbers(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (Character.isLetter(array[i])) { // if it is a letter
                counter++;
            } else {    // not a letter
                counter--;
            }
        }
        return counter == 0;    // if counter is zero, then the count of letters = the count of numbers
    }
}
