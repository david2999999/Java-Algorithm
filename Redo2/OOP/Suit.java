package OOP.DeckOfCards;

// design the data structure for a generic deck of cards
// how would you subclass the data structure to implement black jack
public enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);

    private int value;

    Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        for (Suit s: Suit.values()) {   // loop through all the possible Suit
            if (s.value == value) {
                return s;   // found the Suit
            }
        }

        return null;    // did not find the Suit
    }
}
