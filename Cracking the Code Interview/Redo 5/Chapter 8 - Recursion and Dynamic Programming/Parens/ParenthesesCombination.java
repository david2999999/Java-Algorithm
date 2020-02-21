public class ParenthesesCombination {
    public Set<String> generateParens(int num) {
        Set<String> set = new HashSet<>();

        if (num == 0) {
            return set.add("");
        } else {
            Set<String> previousSet = generateParens(num - 1);
            for (String paren: previousSet) {
                for (int i = 0; i < paren.length(); i++) {
                    if (paren.charAt(i) == '(') {
                        String s = insertInside(paren, i);
                        set.add(s);
                    }

                    set.add("()" + s);
                }
            }
        }

        return set;
    }

    private String insertInside(String str, int index) {
        String before = str.substring(0, index + 1);
        String after = str.substring(index + 1, str.length());
        return left + "()" + right;
    }
}