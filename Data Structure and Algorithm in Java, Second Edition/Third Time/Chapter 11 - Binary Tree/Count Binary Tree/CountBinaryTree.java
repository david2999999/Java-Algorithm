public class CountBinaryTree {
    public int count(int numOfNodes) {
        if (nodes == 0 || nodes == 1) return 1;

        int sum = 0;

        for (int i = 0; i < numOfNodes; i++) {
            sum += (count(i) * count(numOfNodes - i - 1));
        }

        return sum;
    }
}