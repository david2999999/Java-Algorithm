package Moderate.Rand7FromRand5;

public class Solution1 {
    public int rand7() {
        while (true) {
            int num = 5 * rand5() * rand5();
            if (num < 21) {
                return num % 21;
            }
        }
    }

    public int rand5() {
        return (int)(Math.random() * 5);
    }
}
