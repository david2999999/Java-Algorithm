public class ShuffleArray {
    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            int randomIndex = getRandom(currentIndex, array.length - 1);

            if (randomIndex != currentIndex) {
                int currentValue = array[currentIndex];
                array[currentIndex] = array[randomIndex];
                array[randomIndex] = currentValue;
            }
        }
    }
}