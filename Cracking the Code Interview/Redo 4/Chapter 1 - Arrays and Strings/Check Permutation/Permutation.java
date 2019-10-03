public class Permutation {
    public boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) return false;

        return sort(s).equals(sort(t));
    }

    private String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}