public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(convertString("-41242"));
    }

    public static int convertString(String str) {
        if (str == null || str.length() == 0) return 0;

        boolean isNegative = false;
        int currentIndex = 0, result = 0;

        if (str.charAt(0) == '-') {
            isNegative = true;
            currentIndex = 1;
        }

        while (currentIndex < str.length()) {
            result *= 10;
            result += (str.charAt(currentIndex++) - '0');
        }

        return isNegative ? -result : result;
    }
}
