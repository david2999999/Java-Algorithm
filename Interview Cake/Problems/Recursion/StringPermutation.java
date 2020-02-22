public class StringPermutation {
    public Set<String> getPermutations(String inputString) {
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }

        String allCharsExceptLast = inputString.substring(0, inputString.length() - 1);
        char lastChar = inputString.charAt(inputString.length() - 1);

        Set<String> permutationsOfAllCharsExceptLast = getPermutations(allCharsExceptLast);
        Set<String> permutations = new HashSet<>();

        for (String permutation: permutationsOfAllCharsExceptLast) {
            for (int position = 0; position <= allCharsExceptLast.length(); position++) {
                String newPermutation = permutation.substring(0, position) + lastChar + permutation.substring(position);
                permutations.add(newPermutation);
            }
        }

        return permutations;
    }
}