package StringAndArrays;

public class CheckPermutationWithArrays {
    public static void main(String[] args) {
        System.out.println(permutation("olleh", "hello"));
    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128]; // assuming ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int j = 0; j < t.length(); j++) {
            letters[s.charAt(j)]--;
            if (letters[s.charAt(j)] < 0) {
                return false;
            }
        }

        return true;
    }
}
