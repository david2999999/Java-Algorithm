package Hard2.CircusTower;

public class HtWt implements Comparable<HtWt>{ // Height Weight
    private int height;
    private int weight;

    public HtWt(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }


    @Override
    public int compareTo(HtWt second) { // comparing two HtWt
        if (this.height != second.height) { // if the height is different
            return ((Integer)this.height).compareTo(second.height); // compare the height
        } else {
            return ((Integer)this.weight).compareTo(second.weight); // compare the weight
        }
    }

    public boolean isBefore(HtWt other) {
        // if the height and weight of the object are both lower than that of the other object
        if (height < other.height && weight < other.weight) {
            return true;    // yes, you can put this person before the other
        } else {
            return false;   // no, the height and weight needs to be smaller
        }
    }
}
