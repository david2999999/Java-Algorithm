public class PermutationPalindrome3 {
    public boolean isPermutationofPalindrome(char[] phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkMaxOneOdd(bitVector);
    }

    private boolean checkMaxOneOdd(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private int createBitVector(char[] phrase) {
        int bitVector = 0;

        for (char c: phrase) {
            int charNum = getCharNumber(c);

            if (charNum != -1) {
                bitVector = toggleBit(bitVector, charNum);
            }
        }

        return bitVector;
    }

    private int toggleBit(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if (bitVector & mask == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }

        return bitVector;
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