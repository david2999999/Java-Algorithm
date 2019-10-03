package BitManipulation;

public class CheckingDifferenceBetweenTwoIntegers {
    public static void main(String[] args) {
        System.out.println(bitSwapCount(4, 2));
    }

    private static int bitSwapCount(int a, int b) {
        int count = 0;

        for (int c = a ^ b; c != 0; c >>>= 1) {
            count += (c & 1);
        }

        return count;
    }
}
