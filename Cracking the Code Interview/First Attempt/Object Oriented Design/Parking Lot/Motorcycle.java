package ObjectOrientedDesign.ParkingLot;

public class Motorcycle extends Vehicle {
    public Motorcycle() {
        this.size = VehicleSize.Motorcycle;
        this.spotsNeeded = 1;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}
