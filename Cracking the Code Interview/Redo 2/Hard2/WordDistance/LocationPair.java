package Hard2.WordDistance;

public class LocationPair {
    public int location1, location2;

    public LocationPair(int location1, int location2) {
        this.location1 = location1;
        this.location2 = location2;
    }

    public void setLocations(int first, int second) {
        this.location1 = first;
        this.location2 = second;
    }

    public void setLocations(LocationPair loc) {
        setLocations(loc.location1, loc.location2);
    }

    public int distance() {
        return Math.abs(location1 - location2);
    }

    public boolean isValid() {
        // location must be greater or equal to 0 to be valid
        return location1 >= 0 && location2 >= 0;
    }

    public void updateWithMin(LocationPair loc) {
        // if the current location pair is not valid OR
        // the current location pair is greater than the loc parameter
        if (!isValid() || loc.distance() < distance()) {
            setLocations(loc);  // update the min location
        }
    }
}













