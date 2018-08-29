package StringAndArrays;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(permutation("wsup", "pussaw"));
    }

    static String sort(String str) {
        char[] content = str.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }
}
