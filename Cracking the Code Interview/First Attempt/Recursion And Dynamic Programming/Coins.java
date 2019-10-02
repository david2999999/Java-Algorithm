package RecursionAndDynamicProgramming;

public class Coins {
    private int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length) return 1;
        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - denomAmount * i;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }

        return ways;
    }

    private int makeChange(int amount) {
        int[] denoms = { 25, 10, 5, 1 };

        return makeChange(amount, denoms, 0);
    }
}
