public class TestHashSet {
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<String>();
        System.out.printf("set.isEmpty(): %b%n", set.isEmpty());
        Collections.addAll(set, "CN", "FR", "GB", "RU", "US");
        System.out.println(set);
        System.out.printf("set.size(): %d%n", set.size());
        System.out.printf("set.contains(\"GB\"): %b%n", set.contains("GB"));
        System.out.printf("set.contains(\"JP\"): %b%n", set.contains("JP"));
        System.out.printf("set.isEmpty(): %b%n", set.isEmpty());
        set.add("BR");
        System.out.println(set);
        set.remove("FR");
        System.out.println(set);
        String[] array = set.toArray(new String[0]);
        
        for (String string : array) {
            System.out.printf("%s ", string);
        }
        
        System.out.println("");
        Set<String> g8 = new HashSet<String>();
        Collections.addAll(g8, "CA", "DE", "FR", "GB", "IT", "JP", "RU", "US");
        System.out.println(g8);
        g8.retainAll(set);
        System.out.println(g8);
        set.removeAll(g8);
        System.out.println(set);
        set.addAll(g8);
        System.out.println(set);
        set.clear();
        System.out.println(set);
    }
}