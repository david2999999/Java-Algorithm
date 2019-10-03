package ObjectOrientedDesign.DeckOfCards;

import java.util.ArrayList;

public class Deck <T extends Card>{
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setCards(ArrayList<T> cards) {
        this.cards = cards;
    }

    public void shuffle() {}
    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    // just substitute methods, don't mind the implementation
    public T[] dealHand(int number) {
        T[] cards = (T[])new Object[number];
        return cards;
    }

    public T dealCard() {
        T card = null;
        return card;
    }
}
