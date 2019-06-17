package Redo.SortingAndSearching;

public class TreeNodeRank {
    private RankNode root = null;

    public void trackInt(int d) {
        if (root == null) {
            root = new RankNode(d);
        } else {
            root.insert(d);
        }
    }

    public int getRank(int d) {
        if (root == null) return -1;

        return root.getRank(d);
    }

    private class RankNode {
        private int data;
        public RankNode left, right;
        public int leftSize = 0;

        public RankNode(int data) {
            this.data = data;
        }

        public void insert(int d) {
            if (d <= data) {
                if (left == null) {
                    left = new RankNode(d);
                } else {
                    left.insert(d);
                }

                leftSize++;
            } else {
                if (right == null) {
                    right = new RankNode(d);
                } else {
                    right.insert(d);
                }
            }
        }

        public int getRank(int d) {
            if (d == data) {
                return leftSize;
            } else if (d < data) {
                if (left == null) return -1;
                return left.getRank(d);
            } else {
                int rightRank = right == null ? -1 : right.getRank(d);
                if (rightRank == -1) {
                    return -1;
                } else {
                    return rightRank + 1 + leftSize;
                }
            }
        }
    }
}
