package ObjectOrientedDesign.CallCenter;

public enum Rank {
    Director (0), Manager (1), Respondent (2);
    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
