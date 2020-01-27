public class IsUnique2 {
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128]; // ASCII

        for (char c: s.toCharArray()) {
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;

            if (letters[c] < 0) return false;
        }

        return true;
    }
}