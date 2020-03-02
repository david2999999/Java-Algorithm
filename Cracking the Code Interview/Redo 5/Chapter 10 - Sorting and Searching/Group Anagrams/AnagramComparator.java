public class AnagramComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}