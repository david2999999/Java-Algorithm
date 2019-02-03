package Moderate.LivingPeople;

public class Solution4 {
    public int maxAliveYear(Person[] people, int min, int max) {
        int[] populationDelta = getPopulationDeltas(people, min, max);
        int maxAliveYear = getMaxAliveYear(populationDelta);

        return maxAliveYear + min;
    }

    private int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int curentlyAlive = 0;

        for (int year = 0; year < deltas.length; year++) {
            curentlyAlive += deltas[year];
            if (curentlyAlive > maxAlive) {
                maxAliveYear = year;
                maxAlive = curentlyAlive;
            }
        }

        return maxAliveYear;
    }

    private int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] populationDeltas = new int[max - min + 2];
        for (Person person: people) {
            int birth = person.birth - min;
            populationDeltas[birth]++;

            int death = person.death - min;
            populationDeltas[death + 1]--;
        }

        return populationDeltas;
    }
}
