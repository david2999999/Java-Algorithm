package Hard.MajorityElement;

public class Solution1 {
    private int findMajorityElement(int[] array) {
        for (int x: array) {
            if (validate(x, array)) {
                return x;
            }
        }

        return -1;
    }

    private boolean validate(int majority, int[] array) {
        int count = 0;
        for (int n: array) {
            if (n == majority) {
                count++;
            }
        }

        return count > array.length / 2;
    }
}
