package Hard2.SubSequence;

public class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // the length of the subarray
    public int length() {
        return end - start + 1;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    // compare the length of this range with another range
    public boolean shorterThan(Range other) {
        return length() < other.length();
    }
}
