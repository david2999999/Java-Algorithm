public class BruteForce {
    public int getNext(int num) {
        int clone = num;
        int count0 = 0;
        int count1 = 0;

        while ((clone & 1 == 0) && (clone != 0)) {
            count0++;
            clone >>= 1;
        }

        while ((clone & 1 == 1)) {
            count1++;
            clone >>= 1;
        }

        if (count0 + count1 == 31 || count0 + count1 == 0) {
            return -1;
        }

        int rightMostNonTrailingZeroIndex = count0 + count1;

        num |= (1 << rightMostNonTrailingZeroIndex);
        num &= ~((1 << rightMostNonTrailingZeroIndex) - 1);
        num |= (1 << (count1 - 1)) - 1;
        return num;
    }
}