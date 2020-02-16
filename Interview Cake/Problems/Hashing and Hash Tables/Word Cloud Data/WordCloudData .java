public class WordCloudData {
    private Map<String, Integer> wordCount = new HashMap<>();

    public WordCloudData(String inputString) {
        populateWordCounts(inputString);
    }

    private void populateWordCounts(String str) {
        if (str == null || str.isEmpty()) return;

        int currentWordStartIndex = 0;
        int currentWordLength = 0;

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);

            if (i == str.length() - 1) {
                if (Character.isLetter(character)) {
                    currentWordLength++;
                }

                if (currentWordLength > 0) {
                    String currentWord = str.substring(currentWordStartIndex, currentWordStartIndex + currentWordLength);
                    addWordToHashMap(currentWord);
                } else if (character == ' ' || character == '\u2014') {
                    if (currentWordLength > 0) {
                        String currentWord = str.substring(currentWordStartIndex, currentWordStartIndex + currentWordLength);
                        addWordToHashMap(currentWord);
                        currentWordLength = 0;
                    }
                } else if (Character.isLetter(character) || character == '\'') {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }

                    currentWordLength++;
                } else if (character == '-') {
                    if (i > 0 && Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1))) {
                        if (currentWordLength == 0) {
                            currentWordStartIndex = i;
                        }

                        currentWordLength++;
                    } else {
                        if (currentWordLength > 0) {
                            String currentWord = str.substring(currentWordStartIndex, currentWordStartIndex + currentWordLength);
                            addWordToHashMap(currentWord);
                            currentWordLength = 0;
                        }
                    }
                }
            }
        }
    }

    private void addWordToHashMap(String str) {
        if (wordCount.containsKey(str)) {
            wordCount.put(str, wordCount.get(str) + 1);
        } else if (wordCount.containsKey(str.toLowerCase())) {
            int newCount = wordCount.get(str.toLowerCase()) + 1;
            wordCount.put(str.toLowerCase(), newCount);
        } else if (wordCount.containsKey(capitalize(str))) {
            int newCount = wordCount.get(capitalize(str)) + 1;
            wordCount.put(str, newCount);
            wordCount.remove(capitalize(str));
        } else {
            wordCount.put(str, 1);
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + wordCount.substring(1);
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }
}