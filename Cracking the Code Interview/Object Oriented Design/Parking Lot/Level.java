package ObjectOrientedDesign.ParkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int rows) {
        this.floor = floor;
        this.spots = new ParkingSpot[rows + SPOTS_PER_ROW];
        this.availableSpots = rows + SPOTS_PER_ROW;
    }

    // checks the size of the vehicle, checks the amount of spots
    // parks the vehicle, and subtract available spots
    // return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        availableSpots--;
        return true;
    }

    // finds the initial spot to park and then extend it to vehicle.spotsneeded
    private boolean parkStartingAtSpot(int num, Vehicle vehicle) {
        return true;
    }

    // checks the size of the vehicle
    // goes through the array and check if there is a free spot
    // gets the starting index from the spot array
    private int findAvailableSpot(Vehicle vehicle) {
        return 1;
    }

    public void freeSpot() {
        availableSpots++;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }
}
