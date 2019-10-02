package ObjectOrientedDesign.ParkingLot;

public class ParkingSpot {
    private VehicleSize size;
    private Vehicle vehicle;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize size, int row, int spotNumber, Level level) {
        this.size = size;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    // checks the size of the vehicle and compare to the size of this parking spot
    public boolean canFitVehicle(Vehicle vehicle) {
        return true;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        return true;
    }

    public void removeVehicle() {}

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSize() {
        return size;
    }


}
