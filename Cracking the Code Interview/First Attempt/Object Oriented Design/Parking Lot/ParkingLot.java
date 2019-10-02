package ObjectOrientedDesign.ParkingLot;

public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVEL = 10;

    public ParkingLot() {
        this.levels = new Level[NUM_LEVEL];
    }

    // parks the vehicle in a spot, return false if fails
    public boolean parkVehicle(Vehicle vehicle) {
        return true;
    }
}
