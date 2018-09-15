package Redo.OOD.BlackJack;

import java.util.ArrayList;

public class Hand <T extends Card> {
    private ArrayList<T> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(T card) {
        this.cards.add(card);
    }

    public void addCards(ArrayList<T> cards) {
        this.cards.addAll(cards);
    }

    public int value() {
        int score = 0;
        for (T card: cards) {
            score += card.getFaceValue();
        }

        return score;
    }
}
