public class StackWithMin2 extends Stack<Integer> {
    private Stack<Integer> stackMin;

    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public Integer pop() {
        Integer value = super.pop();
        if (value == min()) {
            stackMin.pop();
        }

        return value;
    }

    public void push(Integer value) {
        if (value <= min()) {
            stackMin.push(value);
        }

        super.push(value);
    }

    public Intger min() {
        if (stackMin.isEmpty()) return Integer.MAX_VALUE;
        return stackMin.peek();
    }
}