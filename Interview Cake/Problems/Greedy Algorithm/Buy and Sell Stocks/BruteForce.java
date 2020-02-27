public class BruteForce {
    public int getMaxProfit(int[] stockPrices) {
        if (stockPrices == null || stockPrices.isEmpty()) {
            return 0;
        }

        int maxProfit = 0;

        for (int earlierTime = 0; earlierTime < stockPrices.length; earlierTime++) {
            int earlierPrice = stockPrices[earlierTime];

            for (int laterTime = earlierTime + 1; laterTime < stockPrices.length; laterTime++) {
                int laterPrice = stockPrices[laterTime];
                int potentialProfit = laterPrice - earlierPrice;
                maxProfit = Math.max(maxProfit, potentialProfit);
            }
        }

        return maxProfit;
    }
}