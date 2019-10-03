package RecursionAndDynamicProgramming.TowerOfHanoi;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;  // 3 towers
        Tower[] towers = new Tower[n];

        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);   // give each of the tower an index
        }

        for (int i = n - 1; i >= 0; i--) {
            // the disks on the tower is not in ascending order from top to bottom, largest disk on the bottom
            towers[0].add(i);
        }

        // move n disks from tower[0] to tower[2] using tower[1] as a buffer
        towers[0].moveDisks(n, towers[2], towers[1]);
    }
}
