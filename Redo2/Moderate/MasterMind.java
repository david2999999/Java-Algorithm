package Moderate;

// The computer has four slots and each slot contains a ball that is
// red (R), yellow (Y), green (G), or blue (B)
// the computer might have RGGB
// the user is trying to guess the solution, for example: YRGB
// if you guess the correct color for the correct slot, you get a "hit"
// if you guess a color that exist, but is in the wrong slot, you get a "pseudo-hit"
// implement a method that, given a guess and solution, return the number of hits and pseudo-hit
public class MasterMind {
    // we need a class to store the number of hit and pseduohit
    private static class Result {
        public int hits = 0;
        public int pseudoHits = 0;

        @Override
        public String toString() {
            return "Result{" +
                    "hits=" + hits +
                    ", pseudoHits=" + pseudoHits +
                    '}';
        }
    }

    // converting a character to an integer
    private int charCode(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:    // invalid char color
                return -1;
        }
    }

    int MAX_COLOR = 4;  // the total number of colors

    Result calculateResult(String guess, String solution) {
        // invalid guess, since it does not equal the length of the solution
        if (guess.length() != solution.length()) return null;

        Result result = new Result();   // object to hold the number of hits and pseudo-hits
        int[] frequences = new int[MAX_COLOR];

        for (int i = 0; i < guess.length(); i++) {
            // correct color and correct position
            if (guess.charAt(i) == solution.charAt(i)) {
                result.hits++;  // increment the hit count
            } else {
                // this may be a pseudo-hit, we are going to keep track of the frequency that this character
                // appeared
                int code = charCode(solution.charAt(i));
                frequences[code]++;
            }
        }

        // compute the pseudo hits
        for (int i = 0; i < guess.length(); i++) {
            int code = charCode(guess.charAt(i));
            // if the code is valid AND
            // there is a code in the solution AND
            // the position of the character in the guess is not equal to the position of the character
            // in the solution
            if (code >= 0 && frequences[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                result.pseudoHits++;    // increment the pseudo-hit
                frequences[code]--; // decrement the count, we do not want to over count
            }
        }

        return result;  // return the result of hits and pseudo-hits
    }
}















