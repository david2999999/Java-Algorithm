public class Reverser {
    private String input;

    public Reverser(String in) {
        this.input = in;
    }

    public String reverse() {
        int stackSize = input.length();
        Stack stack = new Stack(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}