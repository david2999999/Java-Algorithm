public class TestTreeSetWithComparator {
    public static void main(String[] args) {
        SortedSet<String> ital = new TreeSet<String>(new RevStringComparator());
        Collections.addAll(ital, "IT", "VA", "SM", "CH");
        System.out.println(ital);
    }
}