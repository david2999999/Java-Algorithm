package Java.LambdaExpression;

import java.util.List;
import java.util.stream.Stream;

public class SolutionWithLambda {
    public int getPopulation2(List<Country> countries, String continent) {
        Stream<Country> sublist = countries.stream().filter(
                country -> { return country.getContinent().equals(continent); }
        );

        Stream<Integer> populations = sublist.map(c -> c.getPopulation());

        int population = populations.reduce(0, (a, b) -> a + b);

        return population;
    }

    public int getPopulation3(List<Country> countries, String continent) {
        Stream<Integer> populations = countries.stream().map(
                c -> c.getContinent().equals(continent) ? c.getPopulation() : 0
        );

        return populations.reduce(0, (a, b) -> a + b);
    }
}
