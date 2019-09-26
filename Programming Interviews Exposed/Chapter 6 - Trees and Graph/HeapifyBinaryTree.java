public class HeapifyBinaryTree {
    public int Node heapify(Node root) {
        int size = traverse(root, 0, null);
        Node[] nodeArray = new Node[size];
        traverse(root, 0, nodeArray);

        Arrays.sort(nodeArray, new Comparator<Node>() {
            @Override
            public int compare(Node m, Node n) {
                int mv = m.getValue();
                int nv = n.getValue();
                return (mv < nv ? -1 : (mv == nv ? 0 : 1));
            }
        });

        for (int i = 0; i < size; i++) {
            int left = 2*i + 1;
            int right = left + 1;
            nodeArray[i].setLeft
        }
    }

    private int traverse(Node node, int count, Node[] arr) {
        if (node == null) {
            return count;
        }

        if (arr != null) {
            arr[count] = node;
        }

        count++;
        count = traverse(node.getLeft(), count, arr);
        count = traverse(node.getRight(), count, arr);
        return count;
    }
}