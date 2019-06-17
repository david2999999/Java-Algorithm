package ArraysAndString.PalindromePermutation;

public class Solution2 {
    public boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;

        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }
}
