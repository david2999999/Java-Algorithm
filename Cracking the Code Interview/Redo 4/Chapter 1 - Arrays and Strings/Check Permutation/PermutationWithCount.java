public class PermutationWithCount {
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] sArray = s.toCharArray();
        for (char c: sArray) {
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