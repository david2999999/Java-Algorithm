public class TestStringStack {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<String>();
        stack.push("GB");
        stack.push("DE");
        stack.push("FR");
        stack.push("ES");
        System.out.println(stack);
        System.out.println("stack.peek(): " + stack.peek());
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println(stack);
        System.out.println("stack.pop(): " + stack.pop());
        System.out.println(stack);
        System.out.println("stack.push(\"IE\"): ");
        stack.push("IE");
        System.out.println(stack);
    }
}