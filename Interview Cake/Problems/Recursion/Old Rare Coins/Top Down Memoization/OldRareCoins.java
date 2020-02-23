public class OldRareCoins {
    private Map<String, Integer> memo = new HashMap<>();

    public int changePossibilitiesTopDown(int amount, int[] denominators) {
        return changePossibilitiesTopDown(amount, denominators, 0);
    }

    private int changePossibilitiesTopDown(int amountLeft, int[] denominators, int currentIndex) {
        int key = amountLeft + ", " + currentIndex;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (amountLeft == 0) {
            return 1;
        } else if (amountLeft < 0 || currentIndex == denominators.length) {
            return 0;
        }

        int currentCoin = denominators[currentIndex];

        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominators, currentIndex + 1);
            amountLeft -= currentCoin;
        }

        memo.put(key, numPossibilities);
        return numPossibilities;
    }
}