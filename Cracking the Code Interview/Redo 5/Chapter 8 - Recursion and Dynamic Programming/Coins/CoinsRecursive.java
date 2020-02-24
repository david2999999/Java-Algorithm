public class CoinsRecursive {
    public int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length - 1) {   // we only have coins that are worth 1 cent
            return 1;
        }

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }

        return ways;
    }
}