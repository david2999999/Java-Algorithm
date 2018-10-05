package Interview;

public class CountingValley {
    public static void main(String[] args) {
        int n = 8;
        String s = "UDDDUDUU";

        System.out.println(count(n, s));
    }

    private static int count(int n, String s) {
        boolean belowWater = false;
        int countValley = 0;
        int currentHeight = 0;

        for (char c: s.toCharArray()) {
            if (c == 'U') {
                currentHeight++;
            } else {
                currentHeight--;
            }

            if (currentHeight >= 0) {
                if (belowWater) belowWater = false;
            } else {
                if (!belowWater) {
                    countValley++;
                    belowWater = true;
                }
            }
        }

        return countValley;
    }
}
