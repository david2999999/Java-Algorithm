public class GreedyBuyStocks {
    public int getMaxProfit(int[] stockPrices) {
        if (stockPrices == null || stockPrices.length < 2) {
            throw new IllegalArgumentException("Invalid stocks prices.");
        }

        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];

            int potentialProfit = currentPrice - minPrice;
            maxProfit = Math.max(maxProfit, potentialProfit);

            minPrice = Math.min(currentPrice, minPrice);
        }

        return maxProfit;
    }
}