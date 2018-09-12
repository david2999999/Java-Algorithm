package Redo.ArrayAndStrings;

public class CheckPalindromeWithCounter {
    private boolean checkPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c: phrase.toCharArray()) {
            int val = getNumericValue(c);

            if (val != -1) {
                table[val]++;

                if (table[val] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    private int getNumericValue(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val;
        }

        return -1;
    }
}
