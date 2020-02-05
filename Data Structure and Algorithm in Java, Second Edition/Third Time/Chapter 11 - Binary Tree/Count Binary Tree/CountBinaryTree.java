public class CountBinaryTree {
    public int count(int numOfNodes) {
        if (numOfNodes == 0 || numOfNodes == 1) return 1;

        System.out.println("Calculating for " + numOfNodes + " nodes.");

        int sum = 0;
        for (int i = 0; i < numOfNodes; i++) {
            sum += (count(numOfNodes - i - 1) * count(i));
        }

        return sum;
    }

    public int countEfficient(int numOfNodes) {
        int[] size = new int[numOfNodes + 1];
        return count(numOfNodes, size);
    }

    public int count(int numOfNodes, int[] size) {
        if (numOfNodes == 0 || numOfNodes == 1) return 1;
        if (size[numOfNodes] > 0) return size[numOfNodes];

        System.out.println("Calculating " + numOfNodes + " nodes");

        int sum = 0;
        for (int i = 0; i < numOfNodes; i++) {
            sum += (count(i, size) * count(numOfNodes - i - 1, size));
        }

        size[numOfNodes] = sum;
        return sum;
    }
}