package Redo.RecursionAndDynamicProgramming.BooleanEvaluation;

import java.util.HashMap;

public class EvaluateWithMemo {

    private int countEval(String s, boolean result, HashMap<String, Integer> memo) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return stringToBool(s) == result ? 1 : 0;
        if (memo.containsKey(result + s)) return memo.get(result + s);

        int ways = 0;

        for (int i = 1; i < s.length(); i+= 2) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1, s.length());

            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);
            int total = (leftFalse * leftTrue) + (rightFalse + rightTrue);

            int totalTrue = 0;

            if (s.charAt(i) == '^') {
                totalTrue = (leftFalse * rightTrue) + (leftTrue * rightFalse);
            } else if (s.charAt(i) == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (s.charAt(i) == '|') {
                totalTrue = (leftFalse * rightTrue) + (leftTrue * rightFalse) + (rightTrue * leftTrue);
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        memo.put(result + s, ways);
        return ways;
    }

    private boolean stringToBool(String s) {
        return s.equals("1");
    }
}
