package Hard.Shuffle;

public class Solution1 {
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    private int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) return cards;

        shuffleArrayRecursively(cards, i - 1);
        int k = rand(0, i);

        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;
    }
}
