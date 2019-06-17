package OOP.ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int availableSpots) {
        this.floor = floor;
        this.availableSpots = availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return true;
    }

    private boolean parkStartingAtSpot(int num, Vehicle v) {
        return true;
    }

    private int findAvailableSpots(Vehicle v) {
        return 1;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}
