public class PostfixParser {
    private Stack stack;
    private String input;

    public PostfixParser(String s){
        this.input = s;
    }

    public int parse() {
        stack = new Stack<>();

        int num1, num2, result;
        char ch;

        for (int i = 0; i < input.length(); i++) {
            if (ch >= '0' && ch <= '9') {
                stack.push((int) (ch - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();

                result = operate(num1, num2, ch);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private int operate(int operand, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand + operand2;
            case '-':
                return operand - operand2;
            case '*':
                return operand * operand2;
            case '/':
                return operand / operand2;
            default:
                return 0;
        }
    }
}