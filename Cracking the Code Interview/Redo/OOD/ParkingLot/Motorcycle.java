package Redo.OOD.ParkingLot;

public class Motorcycle extends Vehicle{

    public Motorcycle() {
        spotNeeded = 1;
        size = VehicleSize.Motorcycle;

    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
