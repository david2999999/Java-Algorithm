package Moderate.LivingPeople;

public class SlightlyBetterBruteForce {
    private int maxAliveYear(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = maxIndex(years);
        return best + min;
    }

    private int[] createYearMap(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];

        for (Person person: people) {
            incrementRange(years, person.birth - min, person.death - min);
        }

        return years;
    }

    private void incrementRange(int[] values, int left, int right) {
        for (int i = left; i <= right; i++) {
            values[i]++;
        }
    }

    private int maxIndex(int[] values) {
        int max = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[max]) {
                max = i;
            }
        }

        return max;
    }
}
