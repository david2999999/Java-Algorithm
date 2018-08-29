package StringAndArrays;

public class isPermutationOfPalindromeWithArrayTable {
    public static void main(String[] args) {
        System.out.println(isPermutation("Tact Coa"));
    }

    static boolean isPermutation(String phrase) {
        phrase = phrase.toLowerCase();
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) return false;

                foundOdd = true;
            }
        }

        return true;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue('c');

        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
    }
}




