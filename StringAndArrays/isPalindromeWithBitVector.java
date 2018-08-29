package StringAndArrays;

public class isPalindromeWithBitVector {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));
    }

    private static boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 && checkExactlyOneBitSet(bitVector);
    }

    private static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c: phrase.toCharArray()) {
            int x = isPermutationOfPalindromeWithArrayTable.getCharNumber(c);
            bitVector = toggleBitVector(bitVector, x);
        }

        return bitVector;
    }

    private static int toggleBitVector(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }

        return bitVector;
    }

    private static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
