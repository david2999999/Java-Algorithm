public class TestTreeSet {
    public static void main(String[] args) {
        NavigableSet<String> engl = new TreeSet<String>();
        Collections.addAll(engl, "IN", "US", "PK", "NG", "PH", "GB", "ZA");
        System.out.println(engl);
        engl.add("KE");
        System.out.println(engl);
        SortedSet<String> head = engl.headSet("KE");
        SortedSet<String> mid = engl.subSet("KE", "US");
        SortedSet<String> tail = engl.tailSet("US");
        System.out.printf("%s %s %s%n", head, mid, tail);
        System.out.printf("engl.first(): %s%n", engl.first());
        System.out.printf("engl.last(): %s%n", engl.last());
    }
}