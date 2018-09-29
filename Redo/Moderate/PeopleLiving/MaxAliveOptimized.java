package Redo.Moderate.PeopleLiving;

public class MaxAliveOptimized {
    private int findMaxYears(Person[] people, int min, int max) {
        int[] populationDelta = generatePopulationDeltas(people, min, max);
        int maxYear = getMaxYear(populationDelta);
        return maxYear + min;
    }

    private int getMaxYear(int[] populationDelta) {
        int maxAliveYear = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;

        for (int year = 0; year < populationDelta.length; year++) {
            currentlyAlive += populationDelta[year];

            if (currentlyAlive > maxAlive) {
                maxAlive = currentlyAlive;
                maxAliveYear = year;
            }
        }

        return maxAliveYear;
    }

    private int[] generatePopulationDeltas(Person[] people, int min, int max) {
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
