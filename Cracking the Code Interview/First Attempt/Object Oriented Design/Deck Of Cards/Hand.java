package ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;

public class Hand <T extends Card>{
    protected ArrayList<T> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}
