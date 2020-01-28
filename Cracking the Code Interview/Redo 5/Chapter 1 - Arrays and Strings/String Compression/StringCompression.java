public class StringCompression {
    public String compress(String s) {
        StringBuilder compress = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;

            if (i + 1 >= s.length || s.charAt(i) != s.charAt(i + 1)) {
                compress.append(s.charAt(i));
                compress.append(count);
                count = 0;
            }
        }

        return compress.length() < s.length() ? compress.toString() : s;
    }
}