public class TowersOfHanoi {
    private static final int NUMBER_OF_TOWERS = 3;
    private static final int NUMBER_OF_DISKS = 5;

    public static void main(String[] args) {
        Tower[] towers = new Tower[NUMBER_OF_TOWERS];

        for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = NUMBER_OF_DISKS; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}