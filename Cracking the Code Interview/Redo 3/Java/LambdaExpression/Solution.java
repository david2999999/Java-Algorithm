package Java.LambdaExpression;

import java.util.List;

public class Solution {
    public int getPopulation(List<Country> countries, String continent) {
        int sum = 0;
        for (Country c : countries) {
            if (c.getContinent().equals(continent)) {
                sum += c.getPopulation();
            }
        }

        return sum;
    }
}
