package Hard.WordDistance;

public class Solution1 {

    public LocationPair findClosest(String[] words, String word1, String word2) {
        LocationPair best = new LocationPair(-1, -1);
        LocationPair current = new LocationPair(-1, -1);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                current.location1 = i;
                best.updateWithMin(current);
            } else if (word.equals(word2)) {
                current.location2 = i;
                best.updateWithMin(current);
            }
        }

        return best;
    }

}
