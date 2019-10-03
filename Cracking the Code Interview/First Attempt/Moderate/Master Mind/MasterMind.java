package Moderate.MasterMind;

public class MasterMind {

    private final int MAX_RESULT = 4;

    private Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;

        Result res = new Result();
        int[] frequencies = new int[MAX_RESULT];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                int code = code(guess.charAt(i));
                frequencies[code]++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }

        return res;
    }

    private int code(char c) {
        switch (c) {
            case 'B': return 0;
            case 'G': return 1;
            case 'R': return 2;
            case 'Y': return 3;
            default: return -1;
        }
    }
}
