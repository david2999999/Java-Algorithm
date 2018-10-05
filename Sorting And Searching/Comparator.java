package Sorting;

import java.util.Arrays;
import java.util.Random;

public class Comparator {
    public static void main(String[] args) {
        Card[] hand = new Card[5];
        Random rand = new Random();

        for (int i = 0; i < 5; i++)
            hand[i] = new Card("Spade", rand.nextInt(12));

        Arrays.sort(hand, new SuitSort());

        for (Card card: hand) {
            System.out.println(card.value);
        }
    }

    static class SuitSort implements java.util.Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            int a = ((Card)o1).getValue();
            int b = ((Card)o2).getValue();

            return a - b;
        }
    }

    private static class Card {

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
    }
}
