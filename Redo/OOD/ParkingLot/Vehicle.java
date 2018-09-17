package Redo.OOD.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots;
    protected String licencePlate;
    protected int spotNeeded;
    private VehicleSize vehicleSize;

    public int getSpots() {
        return spotNeeded;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpot() {
        // loop through arraylist, find the spot and remove it
        // can consider using linkedlist instead of arraylist for parkingspots
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

}
