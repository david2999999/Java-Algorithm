public class HanoiTower {
    public void hanoiTower(int numOfPlates, char x, char y, char z) {
        if (n == 1) {
            System.out.println("Move top disk from " + from + " to " + to);
        } else {
            hanoiTower(numOfPlates - 1, x, z, y); // x -> y using z as buffer
            hanoiTower(1, x, y, z); // x -> 1 plate to z
            hanoiTower(numOfPlates - 1, y, x, z); // y -> z using x as buffer
        }
    }
}