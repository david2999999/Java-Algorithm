package Hard.Shuffle;

public class Solution2 {
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    private int[] shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }

        return cards;
    }
}
