public class Matcher {
    private static final String OPENING = "({[";
    private static final String CLOSING = ")}]";

    public static boolean isMatched(String expression) {
        Stack<Character> buffer = new LinkedStack<>();

        for (char c: expression.toCharArray()) {
            if (isOpeningBracket(c)) {
                buffer.push(c);
            } else if (isClosingBracket(c)) {
                if (buffer.isEmpty()) return false;

                char previousBracket = buffer.pop();
                boolean matchingBracket = OPENING.indexOf(previousBracket) == CLOSING.indexOf(c);

                if (!matchingBracket) return false;
            }
        }

        return buffer.isEmpty();
    }

    private static boolean isOpeningBracket(char c) {
        return OPENING.indexOf(c) != -1;
    }

    private static boolean isClosingBracket(char c) {
        return CLOSING.indexOf(c) != -1;
    }
}