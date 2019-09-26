public class TreeBalancing {
    public Node rotateRight() {
        Node newRoot = left;
        left = newRoot.right;
        newRoot.right = this;
        return newRoot;
    }
}