package Hard.LettersAndNumbers;

public class Solution1 {
    private char[] findLongestSubarray(char[] array) {
        for (int len = array.length; len > 1; len--) {
            for (int i = 0; i < array.length - len; i++) {
                if (hasEqualCharactersAndNumbers(array, i, i + len - 1)) {
                    return extractSubarray(array, i, i + len - 1);
                }
            }
        }

        return null;
    }

    private char[] extractSubarray(char[] array, int start, int end) {
        char[] subarray = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            subarray[i - start] = array[i];
        }

        return subarray;
    }

    private boolean hasEqualCharactersAndNumbers(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (Character.isLetter(array[i]))
                counter++;
            else if (Character.isDigit(array[i])) {
                counter--;
            }
        }

        return counter == 0;
    }
}
