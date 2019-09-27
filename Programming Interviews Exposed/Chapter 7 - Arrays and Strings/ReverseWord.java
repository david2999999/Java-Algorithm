public class ReverseWord {
    public static void main(String[] args) {
        String sentence = "Do or do not, there is no try.";
        System.out.println(reverseWord(sentence));

        char[] str = {
                'i','n',' ','s','e','a','r','c','h',' ','o','f',' ','a','l','g','o','r','i','t','h','m','i','c',' ','e','l','e','g','a','n','c','e'
        };

        reverseWordEfficiently(str);
        for (char c: str) {
            System.out.print(c);
        }
    }

    public static void reverseWordEfficiently(char[] str) {
        reverseString(str, 0, str.length - 1);

        int currentPos = 0, start = 0;
        while (currentPos < str.length) {
            if (str[currentPos] != ' ') {
                start = currentPos;

                while (currentPos < str.length && str[currentPos] != ' ')
                    currentPos++;

                reverseString(str, start, --currentPos);
            }

            currentPos++;
        }
    }

    private static void reverseString(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            start++; end--;
        }
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