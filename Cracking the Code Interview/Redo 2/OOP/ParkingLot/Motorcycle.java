package OOP.ParkingLot;

public class Motorcycle extends Vehicle {

    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return false;
    }
}
