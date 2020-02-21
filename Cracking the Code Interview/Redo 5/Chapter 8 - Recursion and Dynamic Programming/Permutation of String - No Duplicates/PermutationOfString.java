public class PermutationOfString {
    public ArrayList<String> getPermutations(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);

        Arraylist<String> words = getPermutations(remainder);

        for (String word: words) {
            for (int i = 0; i <= word.length; i++) {
                String permutation = insertCharAt(word, first, i);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    private String insertCharAt(String word, char character, int index) {
        String start = word.substring(0, index);
        String end = word.substring(index);
        return start + character + end;
    }
}