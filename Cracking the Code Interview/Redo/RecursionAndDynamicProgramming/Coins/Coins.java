package Redo.RecursionAndDynamicProgramming.Coins;

public class Coins {
    private int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        return makeChange(n, denoms, 0);
    }

    private int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) return 1;

        int ways = 0;
        int denomAmount = denoms[index];

        for (int i = 0; i *  denomAmount <= amount; i++) {
            int amountRemaining = amount - (i * denomAmount);
            ways += makeChange(amountRemaining, denoms, index + 1);
        }

        return ways;
    }
}
