package Java.LambdaRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> subset = new ArrayList<>();
        Random random = new Random();

        for (int item: list) {
            if (random.nextBoolean()) {
                subset.add(item);
            }
        }

        return subset;
    }
}
