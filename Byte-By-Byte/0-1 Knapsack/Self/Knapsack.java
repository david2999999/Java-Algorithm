public class Knapsack {
    private int[][] matrix;

    public Knapsack(int maxWeight, int[] weights, int[] values) {
        if (weights.length == 0 || values.length == 0)
            throw new IllegalArgumentException();

        int highestWeight = getHighestWeight(weights);

        this.matrix = new int[highestWeight + 1][maxWeight + 1];
        generateKnapsackMatrix(maxWeight, weights, values);
    }

    private int getHighestWeight(int[] weights) {
        int highestWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > highestWeight) {
                highestWeight = weights[i];
            }
        }

        return highestWeight;
    }

    private void generateKnapsackMatrix(int maxWeight, int[] weights, int[] values) {
        for (int weightIndex = 1; weightIndex < matrix.length; weightIndex++) {
            for (int maxWeightIndex = 1; maxWeightIndex < matrix[weightIndex].length; maxWeightIndex++) {
                matrix[weightIndex][maxWeightIndex] = Math.max(
                        excludeValue(weightIndex, maxWeightIndex),
                        includeValue(weightIndex, maxWeightIndex, getValue(weightIndex, weights, values)));
            }
        }
    }

    private int getValue(int weightIndex, int[] weights, int[] values) {
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] == weightIndex) {
                return values[i];
            }
        }

        return 0;
    }

    private int excludeValue(int weightIndex, int maxWeightIndex) {
        return matrix[weightIndex - 1][maxWeightIndex];
    }

    private int includeValue(int weightIndex, int maxWeightIndex, int value) {
        int difference = maxWeightIndex - weightIndex;
        int maxComplementValue = 0;

        if (difference < 0) {
            return matrix[weightIndex - 1][maxWeightIndex];
        }  else if (difference >= weightIndex) {
            maxComplementValue = matrix[weightIndex - 1][maxWeightIndex];
        } else {
            maxComplementValue = matrix[weightIndex][difference];
        }

        return maxComplementValue + value;
    }

    public int getMaxValue() {
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + (j < matrix[i].length - 1 ? ", " : ""));
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        Knapsack knapsack = new Knapsack(50, weights, values);
        knapsack.print();

        System.out.println("Max value = " + knapsack.getMaxValue());
    }
}