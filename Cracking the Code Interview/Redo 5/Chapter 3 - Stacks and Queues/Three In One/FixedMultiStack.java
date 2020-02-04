public class FixedMultiStack {
    private static final int NUMBER_OF_STACKS = 3;
    private int stackCapacity;
    private int[] values;
    private int[] stackSize;

    public FixedMultiStack(int stackCapacity) {
        this.values = new int[stackCapacity * NUMBER_OF_STACKS];
        this.stackSize = new int[NUMBER_OF_STACKS];
        this.stackCapacity = stackCapacity;
    }

    public void push(int value, int stackNum) {
        if (isFull(stackNum)) throw new FullStackException();
        stackSize[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();

        int topIndex = indexOfTop(stackNum);
        int temp = values[topIndex];

        values[topIndex] = 0;
        stackSize[stackNum]--;
        return temp;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return stackSize[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return stackSize[stackNum] == stackCapacity;
    }

    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;  // 3 = 1 * 3
        int size = stackSize[stackNum]; // 1
        return offset + size - 1; // 3 + 1 - 1
    }

    public int size(int stackNum) {
        return stackSize[stackNum];
    }
}