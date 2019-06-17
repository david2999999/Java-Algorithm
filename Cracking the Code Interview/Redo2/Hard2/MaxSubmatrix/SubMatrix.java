package Hard2.MaxSubmatrix;

public class SubMatrix {
    private int row1, row2, col1, col2, sum;

    public SubMatrix(int row1, int col1, int row2, int col2, int sum) {
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
