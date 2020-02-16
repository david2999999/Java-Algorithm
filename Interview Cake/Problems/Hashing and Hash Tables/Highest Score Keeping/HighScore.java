public class HighScore {
    public int[] sortScores(int[] scores, int highestPossibleScore, int sortedScoreLength) {
        if (scores == null || scores.isEmpty() || highestPossibleScore < 0) {
            return new int[0];
        }

        int[] scoreCounts = getScoreCount(scores, highestPossibleScore);
        return getSortedCount(scoreCounts, sortedScoreLength);
    }

    protected int[] getSortedCount(int[] scoreCount, int size) {
        int[] sortedScores = new int[size];
        int currentIndex = 0;

        for (int score = scoreCount.length; score >= 0; score--) {
            int count = scoreCount[score];

            for (int occurrence = 0; occurrence < count; occurrence++) {
                if (currentIndex == size) {
                    return sortedScores;
                }

                sortedScores[currentIndex] = score;
                currentIndex++;
            }
        }

        return sortedScores;
    }

    private int[] getScoreCount(int[] scores, int highestScore) {
        int[] scoreCounts = new int[highestScore + 1];

        for (int score: scores) {
            scoreCounts[score]++;
        }

        return scoreCounts;
    }
}