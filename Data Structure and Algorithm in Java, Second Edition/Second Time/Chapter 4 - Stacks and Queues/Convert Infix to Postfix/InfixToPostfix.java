public class InfixToPostfix {
    private Stack stack;
    private String input;
    private StringBuilder output;

    public InfixToPostfix(String in) {
        this.input = in;
        this.stack = new Stack(in.length());
        this.output = new StringBuilder();
    }

    public String translate() {
        for (int j = 0; j < input.length; j++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotClosingParen();
                    break;
                default:
                    output.append(ch);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    private void gotClosingParen() {
        while (!stack.isEmpty()) {
            char top = stack.pop();

            if (top == '(') {
                break;
            } else {
                output.append(top);
            }
        }
    }

    private void gotOperator(char ch, int precedence) {
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                stack.push(top);
                break;
            } else {
                int precedenceOfTop;

                if (top == '+' || top == '-') {
                    precedenceOfTop = 1;
                } else {
                    precedenceOfTop = 2;
                }

                if (precedenceOfTop < precedence) {
                    stack.push(top);
                    break;
                } else {
                    output.append(top);
                }
            }
        }

        stack.push(ch);
    }


}