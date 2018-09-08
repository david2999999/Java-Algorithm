package JavaSection;

import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressions {
    private int getPopulation(List<Country> countries, String continent) {
        Stream<Integer> population = countries.stream().map(
                c -> c.getContinent().equals(continent) ? c.getPopulation() : 0
        );

        return population.reduce(0, (a, b) -> a + b);
    }


    private class Country {

        public String getContinent() {
            return "hello";
        }

        public Integer getPopulation() {
            return 1000;
        }
    }
}
