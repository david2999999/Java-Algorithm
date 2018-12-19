package Hard.ReSpace;

import java.util.HashSet;

public class Respace {

    private ParseResult split(HashSet<String> dictionary, String sentence, int start) {
        if (start >= sentence.length()) {
            return new ParseResult(0, "");
        }

        int bestInvalid = Integer.MAX_VALUE;
        String bestParsing = null;
        String partial = "";
        int index = start;

        while (index < sentence.length()) {
            char c = sentence.charAt(index);
            partial += c;
            int invalid = dictionary.contains(partial) ? 0 : partial.length();

            if (invalid < bestInvalid) {
                ParseResult result = split(dictionary, sentence, index + 1);
                if (invalid + result.invalid < bestInvalid) {
                    bestInvalid = invalid + result.invalid;
                    bestParsing = partial + " " + result.parsed;
                    if (bestInvalid == 0) break;
                }
            }

            index++;
        }

        return new ParseResult(bestInvalid, bestParsing);
    }
}
