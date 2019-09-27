public class ReverseWord {
    public static void main(String[] args) {
        String sentence = "Do or do not, there is no try.";
        System.out.print(reverseWord(sentence));
    }

    public static String reverseWord(String str) {
        if (str == null) return "";

        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 1);

        int wordReadPos, wordEnd;
        int tokenReadPosition = length - 1;

        while (tokenReadPosition >= 0) {
            if (str.charAt(tokenReadPosition) == ' ') {
                sb.append(' ');
                tokenReadPosition--;
            } else {
                wordEnd = tokenReadPosition;

                while (tokenReadPosition >= 0 && str.charAt(tokenReadPosition) != ' ') {
                    tokenReadPosition--;
                }

                wordReadPos = tokenReadPosition + 1;
                while (wordReadPos <= wordEnd) {
                    sb.append(str.charAt(wordReadPos++));
                }
            }
        }

        return sb.toString();
    }
}