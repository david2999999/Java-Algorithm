package Moderate.LivingPeople;

public class Solution2 {
    public int maxAliveYear(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = getMaxIndex(years);
        return best + min;
    }

    private int getMaxIndex(int[] years) {
        int max = 0;
        for (int i = 1; i < years.length; i++) {
            if (years[i] > years[max]) {
                max = i;
            }
        }

        return max;
    }

    private int[] createYearMap(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];
        for (Person person: people) {
            incrementRange(years, person.birth - min, person.death - min);
        }

        return years;
    }

    private void incrementRange(int[] years, int left, int right) {
        for (int i = left; i <= right; i++) {
            years[i]++;
        }
    }
}
