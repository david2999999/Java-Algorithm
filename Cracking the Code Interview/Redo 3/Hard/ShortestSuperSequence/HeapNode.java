package Hard.ShortestSuperSequence;

public class HeapNode {
    public int listNumber;
    public int locationWithinList;

    public HeapNode(int locationWithinList, int listNumber) {
        this.listNumber = listNumber;
        this.locationWithinList = locationWithinList;
    }
}
