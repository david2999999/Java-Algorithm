public class FirstNonRepeatedCharacter {
    public Character firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> characterCount = new HashMap<>();

        Character c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (!characterCount.containsKey(c)) {
                characterCount.put(c, 1);
            } else {
                characterCount.put(c, characterCount.get(c) + 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (characterCount.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

    public String firstNonRepeated(String str) {
        HashMap<Integer, Object> charMap = new HashMap<>();
        Object seenOnce = new Object();
        Object seenTwice = new Object();
        Object seen;

        for (int i = 0; i < str.length(); ) {
            int codePoint = str.codePointAt(i);
            i += Character.charCount(codePoint);
            seen = charMap.get(codePoint);

            if (seen == null) {
                charMap.put(codePoint, seenOnce);
            } else {
                if (seen == seenOnce) {
                    charMap.put(codePoint, seenTwice);
                }
            }
        }

        for (int i = 0; i < str.length(); ) {
            int codePoint = str.codePointAt(i);
            i += Character.charCount(codePoint);

            if (charMap.get(codePoint) == seenOnce) {
                return new String(Character.toChars(codePoint));
            }
        }

        return null;
    }
}