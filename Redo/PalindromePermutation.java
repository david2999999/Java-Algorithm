package Redo;

public class PalindromePermutation {
    public boolean isPalindrome(String phrase) {
        int[] frequencyTable = generateFrequencyTable(phrase);
        return checkAtMostOneOdd(frequencyTable);
    }

    private boolean checkAtMostOneOdd(int[] frequencyTable) {
        boolean foundOdd = false;

        for (int num: frequencyTable) {
            if (num % 2 == 1) {
                if (foundOdd) return false;

                foundOdd = true;
            }
        }

        return true;
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

    private int[] generateFrequencyTable(String phrase) {
        int[] counter = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c: phrase.toCharArray()) {
            int val = getNumericValue(c);

            if (val != -1) {
                counter[val]++;
            }
        }

        return counter;
    }
}
