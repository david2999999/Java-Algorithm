package Moderate.LivingPeople;

import java.util.Arrays;

public class MoreOptimal {

    private int maxAliveYear(Person[] people, int min, int max) {
        int[] births = getSortedYear(people, true);
        int[] deaths = getSortedYear(people, false);

        int maxAlive = 0;
        int currentAlive = 0;
        int birthIndex = 0;
        int deathIndex = 0;
        int maxAliveYear = min;

        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentAlive++;

                if (currentAlive > maxAlive) {
                    maxAlive = currentAlive;
                    maxAliveYear = births[birthIndex];
                }

                birthIndex++;
            } else if (births[birthIndex] > deaths[deathIndex]) {
                currentAlive--;
                deathIndex++;
            }
        }

        return maxAliveYear;
    }


    private int[] getSortedYear(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }

        Arrays.sort(years);
        return years;
    }
}
