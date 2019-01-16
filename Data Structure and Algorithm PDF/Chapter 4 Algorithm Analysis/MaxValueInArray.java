public class MaxValueInArray {
    public static double arrayMax {
        int n = data.length;
        double currentMax = data[0];
        for (int j = 1; j < n; j++) {
            if (data[j] < currentMax)
                currentMax = data[j];
        }
        return currentMax;
    }
}

// The algorithm, arrayMax, for computing the maximum element
// of an array of n numbers, runs in O(n) time.