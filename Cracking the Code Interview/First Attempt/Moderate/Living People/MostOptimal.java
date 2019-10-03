package Moderate.LivingPeople;

public class MostOptimal {
    private int maxAliveYears(Person[] people, int min, int max) {
        int[] populationDeltas = getPopulationDeltas(people, min, max);
        int maxAliveYear = getMaxAliveYear(populationDeltas);
        return maxAliveYear + min;
    }

    private int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] deltas = new int[max - min + 1];

        for (Person person: people) {
            int birth = person.birth - min;
            deltas[birth]++;

            int death = person.death - min;
            deltas[death + 1]--;
        }

        return deltas;
    }

    private int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;

        for (int year = 0; year < deltas.length; year++){
            currentlyAlive += deltas[year];

            if (currentlyAlive > maxAlive) {
                maxAlive = currentlyAlive;
                maxAliveYear = year;
            }
        }

        return maxAliveYear;
    }
}
