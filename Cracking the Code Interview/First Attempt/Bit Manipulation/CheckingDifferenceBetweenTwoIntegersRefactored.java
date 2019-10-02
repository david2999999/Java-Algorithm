package BitManipulation;

public class CheckingDifferenceBetweenTwoIntegersRefactored {
    public static void main(String[] args) {
        System.out.println(checkDiff(4, 2));
    }

    private static int checkDiff(int a, int b) {
        int count = 0;

        for (int c = a ^ b; c != 0; c &= (c - 1)) {
            count++;
        }

        return count;
    }
}
