package ArraysAndString.PalindromePermutation;

public class Solution1 {
    public boolean isPermutation(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOdd(table);
    }

    private boolean checkMaxOdd(int[] table) {
        boolean foundOdd = false;
        for (int count: table) {
            if (count % 2 == 1) {
                if (foundOdd) return false;

                foundOdd = true;
            }
        }

        return true;
    }

    private int[] buildCharFrequencyTable(String phrase) {
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
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }
}
