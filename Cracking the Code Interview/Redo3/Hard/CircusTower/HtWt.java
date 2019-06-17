package Hard.CircusTower;

public class HtWt implements Comparable<HtWt> {
    private int height;
    private int weight;

    public HtWt(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(HtWt second) {
        if (this.height != second.height) {
            return ((Integer)this.height).compareTo(second.height);
        } else {
            return ((Integer)this.weight).compareTo(second.weight);
        }
    }

    public boolean isBefore(HtWt other) {
        return height < other.height && weight < other.weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
