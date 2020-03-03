public class Parentheticals {
    public int getClosingParen(String sentence, int openingParenIndex) {
        int openNestedParens = 0;

        for (int position = openingParenIndex; position < sentence.length(); position++) {
            char c = sentence.charAt(position);

            if (c == '(') {
                openingParenIndex++;
            } else {
                openingParenIndex--;

                if (openingParenIndex == 0) {
                    return position;
                }
            }
        }

        return -1;
    }
}