package Hard2.MaxSubmatrix;

public class MostOptimized {
    public SubMatrix getMaxMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        SubMatrix best = null;

        for (int rowStart = 0; rowStart < rowCount; rowStart++) {
            int[] partialSum = new int[colCount];

            for (int rowEnd = rowStart; rowEnd < rowCount; rowEnd++) {

                for (int i = 0; i < colCount; i++) {
                    partialSum[i] += matrix[rowEnd][i];
                }
                
                Range bestRange = maxSubArray(partialSum, colCount);
                // if there is a higher sum in the range
                if (best == null || best.getSum() < bestRange.sum) {
                    // note: bestRange.start = col start
                    //       bestRange.end = col end
                    best = new SubMatrix(rowStart, bestRange.start, rowEnd, bestRange.end, bestRange.sum);
                }
            }
        }

        return best;
    }

    // find the best sum range for each column
    private Range maxSubArray(int[] array, int N) {
        Range best = null;
        int start = 0;  // the start of the range
        int sum = 0;    // the current sum

        for (int i = 0; i < N; i++) {
            sum += array[i];    // add to the current sum

            // if there is a higher sum
            if (best == null || sum > best.sum) {
                // instantiate a new range with start -> i, with sum
                best = new Range(start, i, sum);
            }

            if (sum < 0) {  // if the sum is less than 0, no point in continuing
                start = i + 1;  // set the current start to the next index
                sum = 0;    // reset the sum
            }
        }

        return best;
    }
}














