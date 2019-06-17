package Redo2.ArraysAndStrings;

public class StringBuilderDemo {
    private String joinWords1(String[] words) {
        String sentence = "";
        for (String w: words) {
            sentence += w;
        }

        return sentence;
    }

    private String joinWords2(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w: words) {
            sentence.append(w);
        }

        return sentence.toString();
    }
}
