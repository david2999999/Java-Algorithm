package RecursionAndDynamicProgramming;

import java.util.ArrayList;

public class ParensOptimized {
    private ArrayList<String> generateParens(int count) {
        ArrayList<String> list = new ArrayList<>();
        char[] str = new char[count * 2];
        addParens(list, count, count, str, 0);
        return list;
    }

    private void addParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;

        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParens(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParens(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
