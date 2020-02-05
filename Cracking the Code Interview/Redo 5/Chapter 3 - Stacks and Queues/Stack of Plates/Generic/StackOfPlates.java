public class StackOfPlates<E> {
    private ArrayList<Stack<E>> stacks = new ArrayList<>();
    private int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public void pushAt(int index, E value) {
        if (isEmpty() || index < 0 || index > stacks.size() - 1) {
            throw new IllegalArgumentException();
        }

        rightShift(index, value, true);
    }

    private void rightShift(int index, E value, boolean insertTop) {
        Stack<E> stack = stacks.get(index);

        if (stack == null) {
            stack = new Stack<E>(capacity);
            stacks.add(stack);
        }

        if (stack.isFull()) {
            E top = stack.pop();
            rightShift(index + 1, top, false);
        }

        stack.insert(insertTop, value);
    }

    private void insert(Stack<E> stack, boolean insertTop, E value) {
        if (insertTop) {
            stack.push(value);
        } else {
            stack.insertBottom(value);
        }
    }
    public E popAt(int index) {
        if (isEmpty() || index < 0 || index > stacks.size() - 1) {
            throw new IllegalArgumentException();
        }

        return leftShift(index, true);
    }

    private E leftShift(int index, boolean removeTop) {
        Stack<E> stack = stacks.get(index);
        E answer = removeTop ? stack.pop() : stack.removeBottom();

        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.getSize() > index + 1) {
            E value = leftShift(index + 1, false);
            stack.push(value);
        }

        return answer;
    }

    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return getLastStack().peek();
    }

    public void push(E value) {
        Stack<E> stack = getLastStack();

        if (stack != null || !stack.isFull()) {
            stack.push(value);
        } else {
            Stack<E> newStack = new Stack<>(capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        Stack<E> stack = getLastStack();

        E value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }

    public boolean isEmpty() {
        Stack<E> lastStack = getLastStack();
        return lastStack == null || lastStack.isEmpty();
    }

    public Stack<E> getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }
}