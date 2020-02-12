public class Knapsack {
    private int[][] matrix;

    public Knapsack(int maxWeight, int[] weights, int[] values) {
        this.matrix = new int[weights.length + 1][maxWeight + 1];
        generateKnapsackMatrix(maxWeight, weights, values);
    }

    private void generateKnapsackMatrix(int maxWeight, int[] weights, int[] values) {
        for (int weightIndex = 1; weightIndex < matrix.length; weightIndex++) {
            for (int maxWeightIndex = 1; maxWeightIndex < matrix[weightIndex].length; maxWeightIndex++) {
                matrix[weightIndex][maxWeightIndex] = Math.max(
                        excludeValue(weightIndex, maxWeightIndex),
                        includeValue(weightIndex, maxWeightIndex, values[weightIndex - 1]));
            }
        }
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
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        Knapsack knapsack = new Knapsack(5, weights, values);
        knapsack.print();

        System.out.println("Max value = " + knapsack.getMaxValue());
    }
}