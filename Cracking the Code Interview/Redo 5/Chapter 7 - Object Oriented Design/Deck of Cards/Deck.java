public class Deck <T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        this.cards = deckOfCards;
    }

    public void shuffle() {}

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number) {}
    public T dealCard() {}
}