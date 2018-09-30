package Redo.Moderate.MasterMind;

public class MasterMind {
    private int code(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }


    private int MAX_COLOR = 4;

    private Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;

        Result result = new Result();
        int[] frequencies = new int[MAX_COLOR];

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                result.hits++;
            } else {
                int code = code(solution.charAt(i));
                frequencies[code]++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int code =  code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                result.pseudoHits++;
                frequencies[code]--;
            }
        }

        return result;
    }
}
