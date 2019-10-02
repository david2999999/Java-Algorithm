package RecursionAndDynamicProgramming;

public class CoinsWithMemoization {
    private int makeChange(int amount) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[amount + 1][denoms.length];

        return makeChange(amount, denoms, 0, map);
    }

    private int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (index >= denoms.length - 1) return 1;
        if (map[amount][index] > 0) return map[amount][index];

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int remainingAmount = amount - i * denomAmount;
            ways += makeChange(remainingAmount, denoms, index + 1, map);
        }

        map[amount][index] = ways;
        return ways;
    }
}
