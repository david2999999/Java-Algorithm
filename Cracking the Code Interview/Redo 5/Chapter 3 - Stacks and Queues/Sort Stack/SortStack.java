public class SortStack {
    public void sort(Stack<Integer> unsortedStack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!unsortedStack.isEmpty()) {
            int temp = unsortedStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                unsortedStack.push(sortedStack.pop());
            }

            sortedStack.push(temp);
        }

        while (!sortedStack.isEmpty()) {
            unsortedStack.push(sortedStack.pop());
        }
    }
}