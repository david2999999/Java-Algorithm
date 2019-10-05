public class PalindromePermutationWithBits {
    public boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }

        return bitVector;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }
}







