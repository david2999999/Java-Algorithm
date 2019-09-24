public class Stack {
    private Element top;

    public boolean push(int data) {
        Element newTop = new Element(data);
        newTop.next = top;
        top = newTop;
        return true;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();

        int data = top.data;
        top = top.next;
        return data;
    }

    public static void main(String args[]) {
        Stack testStack = new Stack();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        System.out.println(testStack.pop());
        System.out.println(testStack.pop());
        System.out.println(testStack.pop());
    }
}
