public class EqualityTest {
    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }

        int[] orig = Arrays.copyOf(data, data.length);

        System.out.println("arrays equal before sort: "+Arrays.equals(data, orig));
        Arrays.sort(data);
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}

// By using a pseudorandom number generator to determine program values, we
//get a different input to our program each time we run it. This feature is, in fact, what
//makes pseudorandom number generators useful for testing code, particularly when
//dealing with arrays. Even so, we should not use random test runs as a replacement
//for reasoning about our code, as we might miss important special cases in test runs.
//Note, for example, that there is a slight chance that the orig and data arrays will be
//equal even after data is sorted, namely, if orig is already ordered. The odds of this
//occurring are less than 1 in 3 million, so it’s unlikely to happen during even a few
//thousand test runs; however, we need to reason that this is possible.