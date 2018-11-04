package CareerCup.FindWords;

import java.util.ArrayList;

public class FindWord {
    public static void main(String[] args) {
        char[][] letters = {{'b','a','d'},
                            {'y','i','r'},
                            {'b','m','g'}};

        ArrayList<Location> locations = findLocationOfWord(letters, "big");

        if (locations != null) {
            for (Location location: locations) {
                System.out.println("(" + location.row + ", " + location.col + ")");
            }
        }
    }

    // Assuming words goes from left to right, top to bottom, to bottom right
    // Assuming we are only looking for one result
    private static ArrayList<Location> findLocationOfWord(char[][] letters, String word) {
        if (word == null || word.length() == 0) return null;
        ArrayList<Location> locations = null; // list of locations
        char[] chars = word.toCharArray(); // changing the word to letters

        // checking for matches in these directions, can be changed to all directions, just need to add a few more variables
        boolean right, bottom, bottomRight;

        outerloop: for (int r = 0; r < letters.length; r++) {
            for (int c = 0; c < letters[r].length; c++) {
                if (letters[r][c] == chars[0]) {    // if there is a match with the first letter
                    right = foundWord(letters, chars, 0, r, c, 0, 1);
                    bottom = foundWord(letters, chars, 0, r, c, 1, 0);
                    bottomRight = foundWord(letters, chars, 0, r, c, 1, 1);

                    if (right) {
                        locations = getLocations(chars.length, r, c, 0, 1);
                        break outerloop;
                    }

                    if (bottom) {
                        locations = getLocations(chars.length, r, c, 1, 0);
                        break outerloop;
                    }

                    if (bottomRight) {
                        locations = getLocations(chars.length, r, c, 1, 1);
                        break outerloop;
                    }
                }
            }
        }

        return locations;
    }

    // recursively matching letters
    private static boolean foundWord(char[][] letters, char[] word, int index,
                                     int row, int col, int rDir, int colDir) {
        if (index >= word.length || row < 0 || row >= letters.length || col < 0 || col >= letters[row].length) return false;

        int letter = word[index];

        // if the letter doesn't match, short circuit the recursive loop
        if (letter != letters[row][col]) {
            return false;
        } else if (index == word.length - 1) {
            return true;
        } else {
            index++;
            // recursively loop to the assigned direction
            return foundWord(letters, word, index, row + rDir, col + colDir, rDir, colDir);
        }
    }

    private static ArrayList<Location> getLocations(int numberOfLetters, int row, int col, int rDir, int colDir) {
        if (numberOfLetters == 0) return null;

        ArrayList<Location> locations = new ArrayList<>();

        while (numberOfLetters != 0) {
            Location location = new Location(row, col);
            locations.add(location);
            numberOfLetters--;

            row += rDir;
            col += colDir;
        }

        return locations;
    }
}

