public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> frequency = new ChainHashMap<>();

        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
        while (doc.hasNext()) {
            String word = doc.next().toLowerCase();
            Integer count = frequency.get(word);

            if (count == null) {
                count = 0;
            }

            frequency.put(word, 1 + count);
        }

        int maxCount = 0;
        String maxWord = "no word";

        for (Entry<String, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("The most frequent word is " + maxWord);
        System.out.println("with " + maxCount + " occurrences.");
    }
}