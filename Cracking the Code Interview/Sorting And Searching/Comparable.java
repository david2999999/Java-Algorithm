package Sorting;

import java.util.Arrays;
import java.util.Random;

public class Comparable {
    public static void main(String[] args) {
        Card[] hand = new Card[5];
        Random rand = new Random();

        for (int i = 0; i < 5; i++)
            hand[i] = new Card("Spade", rand.nextInt(12));

        Arrays.sort(hand);

        for (Card card: hand) {
            System.out.println(card.value);
        }
    }

    private static class Card implements java.lang.Comparable<Card> {

        private String Suit;
        private int value;

        public Card(String suit, int value) {
            Suit = suit;
            this.value = value;
        }

        public String getSuit() {
            return Suit;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int compareTo(Card o) {
            return getValue() - o.getValue();
        }
    }
}
