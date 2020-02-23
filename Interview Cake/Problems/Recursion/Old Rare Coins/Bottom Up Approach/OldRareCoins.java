public class OldRareCoins {
    public int changePossibilitiesBottomUp(int amount, int[] denominators) {
        int[] waysOfDoingNCents = new int[amount + 1];
        waysOfDoingNCents[0] = 1;

        for (int coin: denominators) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }
}