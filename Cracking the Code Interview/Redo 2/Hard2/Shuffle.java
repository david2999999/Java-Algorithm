package Hard2;

// write a method to shuffle a deck of cards. It must be a perfect shuffle - in order words, each of 52!
// permutations of the deck has to be equally likely
public class Shuffle {
    // we have to first shuffle the n - 1 elements. Then shuffle the nth element by randomly swapping it with
    // an element in the array

    // generates a random number from lower -> higher inclusive
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    public int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) {   // base case, do not shuffle the 0th index
            return cards;
        }

        shuffleArrayRecursively(cards, i - 1);  // shuffle n - 1 cards
        int k = rand(0, i); // pick a random number to swap with

        // swap the current card with a random card
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;   // return the shuffled cards
    }


    // this implementation is the iterative approach
    public void shuffleArrayIteratively(int[] cards) {
        // for each card at a specific index
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i); // shuffle with a random index that is equal or lower than the current index

            // swap the two cards
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }
}














