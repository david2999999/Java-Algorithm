package StringAndArrays;

public class isPermutationOfPalindromeWithArrayTable2 {
    public static void main(String[] args) {

        System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }

    private static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c: phrase.toCharArray()) {
            int x = isPermutationOfPalindromeWithArrayTable.getCharNumber(c);
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

}
