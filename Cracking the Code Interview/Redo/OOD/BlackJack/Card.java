package Redo.OOD.BlackJack;

public abstract class Card {
    public int faceValue;
    private Suit suit;
    private boolean available;

    public Card(int faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public abstract int value();

    public boolean isAvailable() { return available; }
    public void markUnavaiable() {
        this.available = false;
    }

    public void markAvaiable() {
        this.available = true;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }
}
