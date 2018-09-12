package Redo;

public class CompressedString {
    private String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            counter++;

            if ( i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(counter);
                counter = 0;
            }
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }
}
