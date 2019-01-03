package OOP.DeckOfCards;

// do not want the user to instantiate a card
// want to extend this card to create different kind of cards
public abstract class Card {
    private boolean available = true;
    protected int faceValue;
    public Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();    // in different kind of card games, the value of the card is different
    public Suit suit() {    // getter for the suit
        return suit;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }
}
