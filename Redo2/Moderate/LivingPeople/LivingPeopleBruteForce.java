package Moderate.LivingPeople;

// given a list of people with their birth and death years
// implement a method to compute the year with the most number of people alive
// you can assume that all people were born between 1900 and 2000 inclusive
// if a person was alive during any portion of that year they should be included in the year count
// such as a person's birth = 1908 and death = 1909 is included in counts for both 1908 and 1909
public class LivingPeopleBruteForce {
    // first we are going to create the person class
    // the brute force method is to go through each year and check how many people are alive at that year

    // the runtime of this is O(RP), where R is the rage of years and P is the number of people
    public int maxAliveYear(Person[] people, int min, int max) {
        int maxAlive = 0;   // the maximum number of people alive at that year
        int maxAliveYear = min; // the year with the most number of people alive

        for (int year = min; year <= max; year++) {
            int alive = 0;  // counting the number of people alive at the current year
            for (Person person: people) {
                if (person.birth <= year && year <= person.death) { // the person is alive
                    alive++;
                }
            }

            if (alive > maxAlive) { // if the current number of people alive in this year is greater than the
                                    // the maximum people alive
                maxAlive = alive;   // update the maximum alive
                maxAliveYear = year;    // update the year of the maximum people alive
            }
        }
        return maxAliveYear;
    }

    // Here is a slightly better brute force method, is to create an array where we
    // track the number of people born at each year, then we iterate through the list of people
    // and increment the array for each year they are alive
    public int maxAliveYear2(Person[] people, int min, int max) {
        int[] years = createYearMap(people, min, max);
        int best = getMaxIndex(years);
        return best + min;  // the year with the most people alive
    }

    // get the index of largest element, which is the maximum number of people alive for that specific year
    private int getMaxIndex(int[] years) {
        int max = 0;
        for (int i = 1; i < years.length; i++) {
            if (years[i] > years[max]) {    // if the current number of people alive is greater than the maximum
                max = i;    // update the maximum
            }
        }

        return max;
    }

    private int[] createYearMap(Person[] people, int min, int max) {
        int[] years = new int[max - min + 1];   // the array to keep track of the number of people alive

        for (Person person: people) {
            incrementRange(years, person.birth - min, person.death - min);
        }

        return years;
    }

    // increment the number of people alive for each of the years
    private void incrementRange(int[] years, int left, int right) {
        for (int i = left; i <= right; i++) {
            years[i]++;
        }
    }

}











