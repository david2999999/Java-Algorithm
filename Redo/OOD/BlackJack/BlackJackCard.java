package Redo.OOD.BlackJack;

public class BlackJackCard extends Card {

    public BlackJackCard(int faceValue, Suit suit) {
        super(faceValue, suit);
    }

    @Override
    public int value() {
        if (isAce()) return 1;
        else if (isFaceCard()) return 10;
        else
            return faceValue;
    }

    public int minValue() {
        if (isAce()) return 1;

        return value();
    }

    public int maxValue() {
        if (isAce()) return 11;

        return value();
    }

    public boolean isAce() {
        return getFaceValue() == 1;
    }

    public boolean isFaceCard() {
        return faceValue > 10 && faceValue < 14;
    }
}
