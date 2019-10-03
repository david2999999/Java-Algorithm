package ObjectOrientedDesign.DeckOfCards;

public class BlackJackCard extends Card {

    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }

    @Override
    public int value() {
        if (isAce()) {
            return 1;
        } else if (faceValue >= 11 && faceValue <= 13) {
            return 10;
        } else {
            return faceValue;
        }
    }

    private boolean isAce() {
        return faceValue == 1;
    }

    public int maxValue() {
        if (isAce()) {
            return 11;
        } else return value();
    }

    public int minValue() {
        if (isAce()) return 1;
        else return faceValue;
    }

    public boolean isFaceCard() {
        return faceValue >= 11 && faceValue <= 13;
    }
}
