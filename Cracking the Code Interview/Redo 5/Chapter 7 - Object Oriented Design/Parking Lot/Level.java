public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int numberSpots) {}

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {}

    public boolean parkStartingAtSpot(int num, Vehicle v) {}

    private int findAvailableSpots(Vehicle vehicle) {}

    public void spotFreed() {
        availableSpots++;
    }
}