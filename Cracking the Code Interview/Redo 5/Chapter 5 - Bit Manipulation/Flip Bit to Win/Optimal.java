public class Optimal {
    public int maxSequenceByFlipBit(int num) {
        if (~num == 0) {
            return Integer.BYTE * 8;
        }

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;

        while (num != 0) {
            int rightMostDigit = num & 1;

            if (rightMostDigit == 1) {
                currentLength++;
            } else if (rightMostDigit == 0) {
                int secondRightMostDigit = num & 2;
                previousLength = secondRightMostDigit == 0 ? 0 : currentLength;
                currentLength = 0;
            }

            maxLength = Math.max(maxLength, currentLength + previousLength + 1);
            num >>>= 1;
        }

        return maxLength;
    }
}