package OOP.ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected int spotsNeeded;
    protected VehicleSize size;

    public void clearSpots() {}

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public void parkInSpot(ParkingSpot s) {
        parkingSpots.add(s);
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }
}
