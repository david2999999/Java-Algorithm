public class Permutation {
    public static void main(String[] args) {
        permute("asd");
    }

    public static void permute(String str) {
        boolean[] used = new boolean[str.length()];
        StringBuilder result = new StringBuilder();
        permute(str, result, used);
    }

    private static void permute(String str, StringBuilder result, boolean[] used) {
        if (result.length() == str.length()) {
            System.out.println(result.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i]) continue;
            result.append(str.charAt(i));
            used[i] = true;
            permute(str, result, used);
            used[i] = false;
            result.setLength(result.length() - 1);
        }
    }
}