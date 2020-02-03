public class HtmlMatcher {
    public static boolean isMatch(String html) {
        Stack<String> buffer = new LinkedStack<>();
        int openingIndex = html.indexOf('<');

        while (openingIndex != -1) {
            int closingIndex = html.indexOf('>', openingIndex + 1);
            if (closingIndex == -1) return false;

            String tag = html.subString(openingIndex + 1, closingIndex);

            if (!isClosingTag(tag)) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty()) return false;
                if (!buffer.pop().equals(tag.substring(1))) return false;
            }

            openingIndex = html.indexOf('<', closingIndex + 1);
        }
    }

    private static boolean isClosingTag(String tag) {
        return tag.startWith('/');
    }
}