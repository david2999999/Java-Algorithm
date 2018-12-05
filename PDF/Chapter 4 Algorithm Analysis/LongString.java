public class LongString {
    public static String repeat1(char c, int n) {
        String answer = "";
        for (int j = 0; j < n; j++) {
            answer += c;
        }
        
        return answer;
    }
    
    public static String repeat2(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(c);
        }
        return sb.toString();
    }
}