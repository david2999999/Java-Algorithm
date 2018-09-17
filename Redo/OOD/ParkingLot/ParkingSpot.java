package Redo.OOD.ParkingLot;

public class ParkingSpot {
    private Level level;
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int row;
    private int col;

    public ParkingSpot(Level level, VehicleSize spotSize, int row, int col) {
        this.level = level;
        this.spotSize = spotSize;
        this.row = row;
        this.col = col;
        this.vehicle = null;
    }

    public boolean isAvailble() {
        return this.vehicle != null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        // compare spotSize with vehicle.size
        return true;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        // check the if the size fit with canFitVehicle()
        // if true - set the vehicle
        // else return false
        return true;
    }

    public boolean removeVehicle() {
        // check if the car is null or not
        // if it is not null
        // set the vehicle field to null then return true
        // else return false
        return true;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
