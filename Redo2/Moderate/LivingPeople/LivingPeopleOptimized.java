package Moderate.LivingPeople;

import java.util.Arrays;

// given a list of people with their birth and death years
// implement a method to compute the year with the most number of people alive
// you can assume that all people were born between 1900 and 2000 inclusive
// if a person was alive during any portion of that year they should be included in the year count
// such as a person's birth = 1908 and death = 1909 is included in counts for both 1908 and 1909
public class LivingPeopleOptimized {
    // for the optimized solution, we will have two sorted arrays
    // one array for all of the birth years
    // another array for the death years
    // then we will loop through the two arrays,
    // incrementing the currently alive when we see a birth year
    // and decrementing the currently alive when we see a death year
    public int maxAliveYear(Person[] people, int min, int max) {
        int[] births = getSortedYears(people, true);
        int[] deaths = getSortedYears(people, false);

        int birthIndex = 0;
        int deathIndex = 0;
        int currentlyAlive = 0;
        int maxAlive = 0;
        int maxAliveYear = min; // set the maxAliveYear to a default min for now

        while (birthIndex < births.length) {    // while we haven't finish looping through the birth array
            if (births[birthIndex] <= deaths[deathIndex]) {
                currentlyAlive++;
                if (currentlyAlive > maxAlive) {
                    maxAlive = currentlyAlive;  // update the maxAlive
                    maxAliveYear = births[birthIndex];  // update the max alive year
                }
                birthIndex++;   // moving on to the next value in the births array
            } else if (births[birthIndex] > deaths[deathIndex]) {
                currentlyAlive--;
                deathIndex++;
            }
        }

        return maxAliveYear;
    }

    private int[] getSortedYears(Person[] people, boolean copyBirthYears) {
        int[] years = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            years[i] = copyBirthYears ? people[i].birth : people[i].death;  // copy birth year or death year
        }

        Arrays.sort(years);
        return years;   // return the sorted years
    }

    // another optimized approach is to create an array showing the population deltas
    // for example, if a person is born at a specific year, the delta will +1
    // if a person dies at a specific year, the delta will -1
    public int maxAliveYear2(Person[] people, int min, int max) {
        int[] populationDeltas = getPopulationDeltas(people, min, max);
        int maxAliveYear = getMaxAliveYear(populationDeltas);
        return maxAliveYear + min;  // the year with most people alive
    }

    private int getMaxAliveYear(int[] deltas) {
        int maxAliveYear = 0;
        int maxAlive = 0;
        int currentlyAlive = 0;

        for (int year = 0; year < deltas.length; year++) {
            // adding the currently alive to the change in population for that year
            currentlyAlive += deltas[year];
            if (currentlyAlive > maxAlive) {    // if the currently alive is greater than the maximum
                maxAliveYear = year;                // update the year
                maxAlive = currentlyAlive;          // update the maximum alive
            }
        }

        return maxAliveYear;    // return the year with the maximum number of people alive
    }

    private int[] getPopulationDeltas(Person[] people, int min, int max) {
        int[] populationDeltas = new int[max - min + 2];
        for (Person person: people) {
            int birth = person.birth - min;
            populationDeltas[birth]++;  // increment when a person is born

            int death = person.death - min;
            // since we want the number of people alive to be inclusive based on the person's birth and death year
            // such as a person's birth = 1908 and death = 1909 is included in counts for both 1908 and 1909
            // we want to decrement at the year 1910, a year later than the death year of the person
            populationDeltas[death + 1]--;  // decrement when a person dies
        }

        return populationDeltas;
    }
}


















