public class PermutationPalindrome {
    public boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean oddFound = false;

        for (int count: table) {
            if (count % 2 == 1) {
                if (oddFound) {
                    return false;
                }

                oddFound = true;
            }
        }

        return true;
    }

    public int[] buildCharFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
           int x = getCharNumber(c);

           if (x != -1) {
               table[x]++;
           }
        }

        return table;
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