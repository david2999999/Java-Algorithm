public class SetOfStacks {
    private ArrayList<Stack> stacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (isEmpty()) return null;
        return stacks.get(stacks.size() - 1);
    }

    public int pop() {
        Stack stack = getLastStack();
        if (isEmpty()) throw new EmptyStackException();

        int value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }

    public void push(int value) {
        Stack stack = getLastStack();

        if (stack != null || !stack.isFull()) {
            stack.push(value);
        } else {
            Stack newStack = new Stack(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) throw new IllegalArgumentException("Invalid index to pop");
        return leftShift(index, true);
    }

    private int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);

        int removedValue;
        if (removeTop) {
            removedValue = stack.pop();
        } else {
            removedValue = stack.removeBottom();
        }

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }

        return removedValue;
    }

    public boolean isEmpty() {
        return stacks.size() == 0;
    }
}