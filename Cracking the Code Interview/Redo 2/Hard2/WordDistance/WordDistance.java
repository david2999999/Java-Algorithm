package Hard2.WordDistance;

// Given any two words, find the shortest distance between them
public class WordDistance {
    // we have to create a location class to keep track of the location of the 2 words
    public LocationPair findClosest(String[] words, String word1, String word2) {
        LocationPair best = new LocationPair(-1, -1);   // keeps track of the best minimum pair
        LocationPair current = new LocationPair(-1, -1);    // current location pair

        for (int i = 0; i < words.length; i++) {
            String word = words[i]; // current word at this index

            if (word.equals(word1)) {   // if the word equal the first word
                current.location1 = i;  // update current location
                best.updateWithMin(current);    // check if we can update the minimum distance
            } else if (word.equals(word2)) {  // if the word equal the second word
                current.location2 = i;  // update the 2nd current location
                best.updateWithMin(current); // check if we can update the minimum distance
            }
        }

        return best;    // return the shorted distance pair
    }
}
