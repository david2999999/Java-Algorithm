public class Calculator {
    private static final String QUIT = 'Q';

    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine();
            char ch = input.charAt(0);

            if (isOperator(ch)) {
                double result = calculate(Double.parseDouble(stack.pop()), Double.parseDouble(stack.pop()), ch);
                stack.push(new Double(result).toString());
            } else if (QUIT.equalsIgnoreCase(ch)) {
                return;
            } else {
                stack.push(input);
            }
        }

        System.out.println("Result from calculation = " + stack.pop());
    }

    private static boolean isOperator(char ch) {
        HashSet<String> operators = new HashSet<>();
        Collections.addAll(operators, "*", "/", "+", "-");
        return operators.contains(ch);
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            default:
                return 0;
        }
    }
}