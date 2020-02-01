public class StringConcat {
    public static String repeat(char c, int n) {
        String answer = "";

        for (int j = 0; j < n; j++) {
            answer += c;
        }

        return answer;
    }
}