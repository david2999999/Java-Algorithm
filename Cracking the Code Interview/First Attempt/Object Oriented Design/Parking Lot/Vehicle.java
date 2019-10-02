package ObjectOrientedDesign.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        this.parkingSpots.add(spot);
    }

    public void clearSpots() {}

    public abstract boolean canFitInSpot(ParkingSpot spot);
}


