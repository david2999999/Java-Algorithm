package Redo.RecursionAndDynamicProgramming.BooleanEvaluation;

public class Evaluate {
    private int countEval(String s, boolean result) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1: 0;

        int ways = 0;
        for (int i = 1; i < s.length(); i+=2) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());

            int leftTrue = countEval(left, true);
            int leftFalse = countEval(left, false);
            int rightTrue = countEval(right, true);
            int rightFalse = countEval(right, false);
            int total = (leftFalse + leftTrue) * (rightFalse + rightTrue);

            int totalTime = 0;
            if (c == '^') {
                totalTime = (leftTrue * rightFalse) + (leftFalse * rightTrue);
            } else if (c == '&') {
                totalTime = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTime = (leftFalse * rightTrue) + (leftTrue * rightFalse) + (rightTrue * leftTrue);
            }

            int subways = result ? totalTime : total - totalTime;
            ways += subways;
        }

        return ways;
    }

    private boolean stringToBool(String s) {
        return s.equals("1");
    }
}
