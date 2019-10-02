package Moderate.LivingPeople;

public class BruteForce {
    private int maxAliveYear(Person[] people, int min, int max) {
        int maxAlive = 0;
        int maxAliveYear = min;

        for (int year = min; year <= max; year++) {
            int alive = 0;

            for (Person person: people) {
                if (person.birth <= year && person.death >= year) {
                    alive++;
                }
            }

            if (alive > maxAlive) {
                maxAlive = alive;
                maxAliveYear = year;
            }
        }

        return maxAliveYear;
    }
}
