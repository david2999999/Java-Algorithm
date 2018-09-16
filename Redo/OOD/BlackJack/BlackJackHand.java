package Redo.OOD.BlackJack;

import java.util.ArrayList;

public class BlackJackHand extends Hand<BlackJackCard>{
    public int score() {
        ArrayList<Integer> allScores = possibleScores();

        int minOver = Integer.MAX_VALUE;
        int maxUnder = Integer.MIN_VALUE;

        for (int score: allScores) {
            if (score < minOver && score > 21) {
                minOver = score;
            }

            if (score > maxUnder && score <= 21) {
                maxUnder = score;
            }
        }

        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;

    }

    public ArrayList<Integer> possibleScores() {
        return new ArrayList<>();
    }

    public boolean isBusted() {
        return score() > 21;
    }

    public boolean is21() {
        return score() == 21;
    }

    public void isBlackJack() {
        // check the hand for 2 cards
        // check for king and ace
    }
}
