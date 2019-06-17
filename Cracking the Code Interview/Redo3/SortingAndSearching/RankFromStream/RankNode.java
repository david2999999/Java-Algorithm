package SortingAndSearching.RankFromStream;

public class RankNode {
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;

    public RankNode(int data) {
        this.data = data;
    }

    public void insert(int d) {
        if (d <= data) {
            if (left != null) {
                left.insert(d);
            } else {
                left = new RankNode(d);
            }

            left_size++;
        } else {
            if (right != null) {
                right.insert(d);
            } else {
                right = new RankNode(d);
            }
        }
    }

    public int getRank(int d) {
        if (d == data) {
            return left_size;
        } else if (d < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int right_rank = right.getRank(d);
            if (right_rank == -1) return -1;
            else {
                return left_size + right_rank + 1;
            }
        }
    }
}













