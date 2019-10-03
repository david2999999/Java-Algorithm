package Hard.CircusTower;

public class HtWt implements Comparable<HtWt> {
    private int height;
    private int weight;

    public HtWt(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public boolean isBefore(HtWt other) {
        if (height < other.height && weight < other.weight)
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(HtWt second) {
        if (this.height != second.height) {
            return ((Integer)this.height).compareTo(second.height);
        } else {
            return ((Integer)this.weight).compareTo(second.weight);
        }
    }
}
