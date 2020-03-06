public class RankNode {
    public int leftSize = 0;
    public RankNode left, right;
    public int data = 0;

    public RankNode(int d) {
        data = d;
    }

    public void insert(int d) {
        if (d <= data) {
            if (left != null) {
                left.insert(d);
            } else {
                left = new RankNode(d);
            }

            leftSize++;
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
            return leftSize;
        } else if (d < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRank(d);
            }
        } else {
            int rightRank = right == null ? -1 : right.getRank(d);

            if (rightRank == -1) {
                return -1;
            } else {
                return leftSize + 1 + rightRank;
            }
        }
    }
}