package OOP.ParkingLot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int spotNumber;
    private Level level;

    public ParkingSpot(VehicleSize spotSize, int row, int spotNumber, Level level) {
        this.spotSize = spotSize;
        this.row = row;
        this.spotNumber = spotNumber;
        this.level = level;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return true;
    }

    public boolean park(Vehicle v) {
        return true;
    }

    public int getRow() {
        return row;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
