public class PalindromePermutation {
    public boolean isPalindromePermutation(String str) {
        if (str == null) return false;
        if (str.isEmpty() || str.length() == 0) return true;

        Set<Character> unpairedCharacters = new HashSet<>();

        for (char c: str.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        return unpairedCharacters.size() <= 1;
    }
}