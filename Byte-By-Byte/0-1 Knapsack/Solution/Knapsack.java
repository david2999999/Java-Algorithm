public class Knapsack {
    public int knapsack(int maxWeight, int[] weights, int[] values) {
        return knapsack(maxWeight, weights, values, 0);
    }

    public int knapsack(int maxWeight, int[] weights, int[] values, int currentIndex) {
        if (currentIndex == weights.length) return 0;
        if (maxWeight - weights[i] < 0) {
            return knapsack(maxWeight, weights, values, currentIndex + 1);
        }

        return Math.max(
                knapsack(maxWeight - weights[i], weights, values, currentIndex + 1) + values[currentIndex],
                knapsack(maxWeight, weights, values, currentIndex + 1));
    }
}