package Redo.OOD.ParkingLot;

public class Bus extends Vehicle{
    public Bus() {
        spotNeeded = 5;
        size = VehicleSize.Large;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
