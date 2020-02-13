public class BoyerMoore {
    public int find(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;

        Map<Character, Integer> last = createLastMap(text, pattern);

        int textIndex = patternLength - 1;
        int patternIndex = patternLength - 1;

        while (textIndex < textLength) {
            if (text[textIndex] == pattern[patternIndex]) {
                if (patternIndex == 0) {
                    return textIndex;
                }

                patternIndex--;
                textIndex--;
            } else {
                textIndex += patternLength - (Math.min(patternIndex, 1 + last[textIndex]));
                patternIndex = patternLength - 1;
            }
        }

        return -1;
    }

    private HashMap<Character, Integer> createLastMap(char[] text, char[] pattern) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: text) {
            map.put(c, -1);
        }

        for (int i = 0; i < pattern.length; i++) {
            map.put(pattern[i], i);
        }

        return map;
    }
}