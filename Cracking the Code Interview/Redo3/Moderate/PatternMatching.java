package Moderate;

public class PatternMatching {
    public boolean doesMatch(String pattern, String value) {
        if (pattern.length() == 0) return value.length() == 0;

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b' : 'a';
        int size = value.length();

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;

        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = size - mainSize * countOfMain;
            String first = value.substring(0, mainSize);

            if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0 : remainingLength / countOfAlt;

                String second = countOfAlt == 0 ? "" : value.substring(altIndex, altIndex + altSize);

                String cand = buildFromPattern(pattern, first, second);
                if (cand.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    private String buildFromPattern(String pattern, String main, String alt) {
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);

        for (int c: pattern.toCharArray()) {
            if (c == first) {
                sb.append(main);
            } else {
                sb.append(alt);
            }
        }

        return sb.toString();
    }

    private int countOf(String pattern, char c) {
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
}
