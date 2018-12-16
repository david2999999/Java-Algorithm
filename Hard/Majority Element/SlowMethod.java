package Hard.MajorityElement;

public class SlowMethod {
    private int findMajority(int[] array) {
        for (int x : array) {
            if (validate(array, x)) {
                return x;
            }
        }
        return -1;
    }


    private boolean validate(int[] array, int majority) {
        int count = 0;
        for (int n: array) {
            if (n == majority)
                count++;
        }

        return count > array.length / 2;
    }
}
