public class PermutationPalindrome {
    public boolean isPermutationOfPalindrome(char[] phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c: phrase) {
            int charNum = getCharNumber(c);
            if (charNum != -1) {
                table[charNum]++;

                if (table[charNum] % 2 == 1) {
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
        int c = Character.getNumericValue(c);

        if (a <= c && c <= z) {
            return c - a;
        }

        return -1;
    }
}