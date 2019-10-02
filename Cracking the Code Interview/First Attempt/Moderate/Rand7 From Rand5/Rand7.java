package Moderate.Rand7FromRand5;

import java.util.Random;

public class Rand7 {
    private int generateRand7() {
        while (true) {
            int num = 5 * Rand5() + Rand5();

            if (num <21) {
                return num % 7;
            }

        }
    }

    private int Rand5() {
        Random random = new Random();
        return random.nextInt(5);
    }
}
