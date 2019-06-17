package Redo.RecursionAndDynamicProgramming.Coins;

public class CoinsOptimized {
    private int makeChange(int amount) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[amount + 1][denoms.length];

        return makeChange(amount, denoms, 0, map);
    }

    private int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) return map[amount][index];
        if (index >= denoms.length - 1) return 1;

        int ways = 0;
        int denomAmount = denoms[index];
        for (int i = 0; i * denomAmount <= amount; i++) {
            int remaining = amount - (i * denomAmount);
            ways +=  makeChange(remaining, denoms, index + 1, map);
        }

        map[amount][index] = ways;
        return ways;
    }
}
