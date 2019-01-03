package OOP.DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

// using generic to create deck with different kind of cards
public class Deck <T extends Card> {
    private ArrayList<T> cards; // all the cards in the deck, dealt or not
    private int dealtIndex = 0; // marks the first undealt card

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
        shuffle(cards);
    }

    public void shuffle(ArrayList<T> cards) {
        Collections.shuffle(cards); // shuffle the cards
    }

    public T[] dealHand(int number) {
        T[] hand = (T[]) new Object[number];    // will cause a warning about class cast exception
        int currentNumOfCards = 0;

        for (int i = dealtIndex; i < cards.size(); i++) {
            if (number == 0) {  // no more cards needed to this hand
                return hand;
            }

            number--;
            hand[currentNumOfCards++] = cards.get(i);
        }

        return null;    // not enough cards in this deck for the number of cards
    }

    public T dealCard() {
        if (cards.size() == dealtIndex) {
            return null;    // no more cards to deal
        }

        return cards.get(dealtIndex);
    }
}













