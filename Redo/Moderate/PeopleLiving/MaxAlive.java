package Redo.Moderate.PeopleLiving;

import java.util.Arrays;

public class MaxAlive {

    private int maxAliveYear(Person[] people, int min, int max) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min;

        while (birthIndex < births.length) {
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++;

                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;
                    maxAliveYear = births[birthIndex];
                }

                birthIndex++;
            } else if (births[birthIndex] > deaths[deathIndex]){
                currentlyAlive--;
                deathIndex++;
            }
        }

        return maxAliveYear;

    }

    private int[] getSortedYears(Person[] people, boolean copyBirthYear) {
        int[] years = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYear ? people[i].birth : people[i].death;
        }

        Arrays.sort(years);
        return years;
    }
}
