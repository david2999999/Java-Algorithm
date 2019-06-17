package Redo.Moderate.PatternMatching;

public class Optimized {
    private boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';
        int size = value.length();

        int mainCount = count(pattern, mainChar);
        int altCount = pattern.length() - mainCount;
        int firstAltIndex = pattern.indexOf(altChar);

        int maxMainSize = value.length() / mainCount;

        for (int i = 0; i <= maxMainSize; i++) {
            String main = value.substring(0, i);

            int remainingSize = size - i * mainCount;
            if (altCount == 0 || remainingSize % altCount == 0) {
                int altIndex = firstAltIndex * i;
                int altLength = altCount == 0 ? 0 : remainingSize / altCount;
                String alt = altCount == 0 ? "" : value.substring(altIndex, altIndex + altLength);

                String cand = buildFromPattern(pattern, main, alt);

                if (cand.equals(value)) return true;

            }
        }

        return false;

    }

    private String buildFromPattern(String pattern, String main, String alt) {
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);

        for (char c: pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }

        return sb.toString();
    }

    private int count(String pattern, char c) {
        int count = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

}
