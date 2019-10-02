package Interview;

public class FormatNumberToString {
    public static void main(String[] args) {
        System.out.println(convertNum(1000000000));
    }

    private static String convertNum(int num) {
        if (num == 0) return Integer.toString(0);

        StringBuilder sb = new StringBuilder();
        int numProcessed = 0;

        while (num > 0) {
            if (numProcessed != 0 && numProcessed % 3 == 0) {
                sb.insert(0, ',');
            }

            sb.insert(0, Integer.toString(num % 10));
            num /= 10;
            numProcessed++;
        }

        return sb.toString();
    }
}
