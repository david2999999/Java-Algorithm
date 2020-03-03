public class MatchingBracket {
    public boolean isValid(String code) {
        Map<Character, Character> openersToClosers = new HashMap<>();
        openersToClosers.put('(', ')');
        openersToClosers.put('[', ']');
        openersToClosers.put('{', '}');

        Set<Character> openers = openersToClosers.keySet();
        Set<Character> closers = new HashSet<>(openersToClosers.values());

        Deque<Character> openersStack = new ArrayDeque<>();

        for (char c: code.toCharArray()) {
            if (openers.contains(c)) {
                openersStack.push(c);
            } else {
                if (openersStack.isEmpty()) {
                    return false;
                } else {
                    char lastUnclosedOpener = openersStack.pop();

                    if (openersToClosers.get(lastUnclosedOpener) != c) {
                        return false;
                    }
                }
            }
        }

        return openersStack.isEmpty();
    }
}