public class BracketChecker {
    private String input;

    public BracketChecker(String in) {
        this.input = in;
    }

    public boolean check() {
        int stackSize = input.length();
        Stack stack = new Stack(stackSize);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch=='}' && chx!='{') ||
                                (ch==']' && chx!='[') ||
                                (ch==')' && chx!='(')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }
}