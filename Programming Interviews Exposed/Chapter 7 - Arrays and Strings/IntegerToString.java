public class IntegerToString {
    public static final int MAX_DIGITS = 10;

    public static void main(String[] args) {
        System.out.println(convert(-1231412));
    }

    public static String convert(int num) {
        boolean isNegative = false;

        if (num < 0) {
            if (num == Integer.MIN_VALUE) return "-2147483648";

            isNegative = true;
            num = -num;
        }

        int currentIndex = 0;
        char[] temp = new char[MAX_DIGITS + 1];

        do {
            temp[currentIndex++] = (char) ((num % 10) + '0');
            num /= 10;
        } while (num != 0);

        StringBuilder sb = new StringBuilder();
        if (isNegative) sb.append("-");

        while(currentIndex > 0) {
            sb.append(temp[--currentIndex]);
        }

        return sb.toString();
    }
}