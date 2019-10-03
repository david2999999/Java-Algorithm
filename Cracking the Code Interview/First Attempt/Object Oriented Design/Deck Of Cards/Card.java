package ObjectOrientedDesign.DeckOfCards;

public abstract class Card {
    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();

    public Suit suit() { return suit; }

    public boolean isAvailable() { return available; }
    public void markUnavailable() { this.available = false; }
    public void markAvailable() { this.available = true; }


}
