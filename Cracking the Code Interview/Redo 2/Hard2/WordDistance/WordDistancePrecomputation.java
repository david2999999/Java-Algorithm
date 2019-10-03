package Hard2.WordDistance;

import CodeLibrary.HashMapList;

import java.util.ArrayList;

// Given any two words, find the shortest distance between them
public class WordDistancePrecomputation {
    // in this example, we will first find all of the locations of the 2 words and separate them into 2 lists
    // and then we can loop through the two list to find the minimum distance

    // pre-computation of locations of words
    HashMapList<String, Integer> getWordLocations(String[] words) {
        HashMapList<String, Integer> locations = new HashMapList<>();
        for (int i = 0; i < words.length; i++) {
            locations.put(words[i], i); // store the word and its locations
        }

        return locations;
    }

    public LocationPair findClosest(String word1, String word2, HashMapList<String, Integer> locations) {
        ArrayList<Integer> location1 = locations.get(word1);    // get all locations of word1
        ArrayList<Integer> location2 = locations.get(word2);    // get all locations of word2
        return findMinDistancePair(location1, location2);
    }

    private LocationPair findMinDistancePair(ArrayList<Integer> array1, ArrayList<Integer> array2) {
        // checking for invalid array list
        if (array1 == null || array2 == null || array1.size() == 0 || array2.size() == 0) {
            return null;
        }

        // keep track of the indexes as we loop through it
        int index1 = 0;
        int index2 = 0;
        LocationPair best = new LocationPair(array1.get(0), array2.get(0)); //  the minimum distance pair
        LocationPair current = new LocationPair(array1.get(0), array2.get(0)); // the current distance pair

        while (index1 < array1.size() && index2 < array2.size()) {
            current.setLocations(array1.get(index1), array2.get(2));    // set the current location
            best.updateWithMin(current);    // checking if the current pair is the minimum

            // location1 - location2 = difference
            if (current.location1 < current.location2) {    // if location1 is smaller than location2
                index1++;   // we want to make location1 bigger, to make a smaller difference
            } else {    // if location1 is greater than location2
                index2++;   // increment the index of location2
            }
        }

        return best;    // return the minimum distance pair
    }

}













