package Redo.OOD.BlackJack;

import java.util.ArrayList;

public class Deck <T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex;

    public Deck(ArrayList<T> cards) {
        this.cards = cards;
        this.dealtIndex = 0;
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public void shuffle() {}

    public T dealtCard() {
        if (cards != null) {
            return cards.get(dealtIndex++);
        }

        return null;
    }

    public ArrayList<T> dealtCards(int numOfCards) {
        ArrayList<T> cards = new ArrayList<>();
        for (int i = 0; i < numOfCards; i++) {
            cards.add(dealtCard());
        }

        return cards;
    }
}
