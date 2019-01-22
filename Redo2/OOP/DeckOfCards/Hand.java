package OOP.DeckOfCards;

import java.util.ArrayList;

public class Hand <T extends Card> {
    protected ArrayList<T> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (T card: cards) {
            score += card.value();  // add all of the value of each card in the hand
        }

        return score;
    }

    public void addCard(T card) {
        cards.add(card);    // add another card into the hand
    }

    // this tutorial will continue in part 2
}
