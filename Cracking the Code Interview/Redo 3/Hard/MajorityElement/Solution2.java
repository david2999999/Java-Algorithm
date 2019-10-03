package Hard.MajorityElement;

public class Solution2 {
    private int findMajorityElement(int[] array) {
        int candidate = getCandidate(array);
        return validate(array, candidate) ? candidate : -1;
    }

    private boolean validate(int[] array, int majority) {
        int count = 0;
        for (int n: array) {
            if (n == majority) {
                count++;
            }
        }

        return count > array.length / 2;
    }

    private int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;

        for (int n: array) {
            if (count == 0) {
                majority = n;
            }

            if (majority == n) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}
