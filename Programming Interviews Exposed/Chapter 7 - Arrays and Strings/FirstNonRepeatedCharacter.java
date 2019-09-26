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
}