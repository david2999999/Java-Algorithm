package Hard2;

// write a method to random generate a set of m integers from and array of size n.
// Each element must have equal probability of being chosen
public class RandomSet {
    // generates a number from lower -> higher inclusive
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    public int[] pickRandomSet(int[] original, int m) {
        int[] subset = new int[m];

        // copy the first m elements from the original array to the new subset
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {
            int k = rand(0, i); // generates a random number from 0 to i
            if (k < m) {    // if the random number is lower than m
                subset[k] = original[i];    // set the element at position k to a new element
            }
        }

        return subset;  // return the randomly generated subset
    }

}
