public class TowerOfHanoi {
    public void moveTower(int numOfPlates, char source, char buffer, char destination) {
        if (numOfPlates == 0) {
            System.out.println("Disk 1 from " + source + " to " + destination);
        } else {
            moveTower(numOfPlates - 1, source, destination, buffer);
            System.out.println("Disk " + numOfPlates + " from " + source + " to " + destination);
            moveTower(numOfPlates - 1, buffer, source, destination);
        }
    }
}