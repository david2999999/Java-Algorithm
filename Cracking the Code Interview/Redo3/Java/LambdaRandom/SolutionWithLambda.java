package Java.LambdaRandom;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SolutionWithLambda {
    public List<Integer> getRandomSubset(List<Integer> list) {
        Random random = new Random();
        List<Integer> subset = list.stream().filter(
                k -> random.nextBoolean()
        ).collect(Collectors.toList());

        return subset;
    }
}
