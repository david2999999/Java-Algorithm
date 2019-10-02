package Moderate;

import java.util.Stack;

public class Calculator {
    private enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK
    }

    private double compute(String sequence) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {
            try {
                int value = parseNextNumber(sequence, i);
                numberStack.push((double)value);

                i += Integer.toString(value).length();
                if (i >= sequence.length()) break;

                Operator op = partNextOperator(sequence, i);
                collapseTop(op, numberStack, operatorStack);
                operatorStack.push(op);

            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE;
            }
        }

        collapseTop(Operator.BLANK, numberStack, operatorStack);
        if (numberStack.size() == 1 && operatorStack.size() == 0) {
            return numberStack.pop();
        }

        return 0;
    }

    private void collapseTop(Operator futureTop, Stack<Double> numberStack, Stack<Operator> operatorStack) {
        while (numberStack.size() >= 2 && operatorStack.size() >= 1) {
            if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())) {
                double second = numberStack.pop();
                double first = numberStack.pop();
                Operator op = operatorStack.pop();
                double result = applyOp(first, op, second);
                numberStack.push(result);
            } else {
                break;
            }
        }
    }

    private int priorityOfOperator(Operator op) {
        switch (op) {
            case ADD: return 1;
            case SUBTRACT: return 1;
            case MULTIPLY: return 2;
            case DIVIDE: return 2;
            case BLANK: return 0;
        }

        return 0;
    }

    private double applyOp(double left, Operator op, double right) {
        if (op == Operator.ADD) return left + right;
        else if (op == Operator.MULTIPLY) return left * right;
        else if (op == Operator.SUBTRACT) return left - right;
        else if (op == Operator.DIVIDE) return left / right;
        else return right;
    }

    private int parseNextNumber(String sequence, int offset) {
        StringBuilder sb = new StringBuilder();
        while (offset < sequence.length() && Character.isDigit(sequence.charAt(offset))) {
            sb.append(sequence.charAt(offset));
            offset++;
        }

        return Integer.parseInt(sb.toString());
    }

    private Operator partNextOperator(String sequence, int offset) {
        if (offset < sequence.length()) {
            char op = sequence.charAt(offset);

            switch (op) {
                case '+': return Operator.ADD;
                case '-': return Operator.SUBTRACT;
                case '*': return Operator.MULTIPLY;
                case '/': return Operator.DIVIDE;
            }
        }

        return Operator.BLANK;
    }
}
