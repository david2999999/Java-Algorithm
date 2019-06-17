package Redo.OOD.ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[][] parkingSpots;
    private int availableSpots;
    private static final int NUM_SPOTS_PER_ROW = 10;
    private static final int NUM_SPOTS_PER_COL = 10;

    public Level(int floor) {
        this.floor = floor;
        parkingSpots = new ParkingSpot[NUM_SPOTS_PER_ROW][NUM_SPOTS_PER_COL];
        availableSpots = NUM_SPOTS_PER_COL * NUM_SPOTS_PER_ROW;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        // loops through the parkspots and find available space
        // depending on the spots needed for the vehicle
        // decrease spot available
        return false;
    }

    public boolean parkStartingAtSpot(int num, Vehicle v) {
        // go to that index of the array
        // check the vehicle spot needed
        // determine if there is enough space in that row

        // decrease spot available
        return true;
    }

    private int findAvailableSpot(Vehicle v) {
        // using the spots needed for the vehicle
        // find the index that is free inside the array
        return 1;
    }

    public void freedSpot() {
        availableSpots++;
    }


}
