package Hard.RandomSet;

public class RandomSetIteratively {
    private int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    public int[] pickIteratively(int[] original, int m) {
        int[] subset = new int[m];

        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
        }

        return subset;
    }
}
