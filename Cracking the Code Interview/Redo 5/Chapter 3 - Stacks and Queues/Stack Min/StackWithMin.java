public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int minValue = Math.min(value, min());
        super.push(new NodeWithMin(value, minValue));
    }

    public int min() {
        if (isEmpty()) return Integer.MAX_VALUE;

        return peek().min;
    }
}