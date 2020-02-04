public class TestArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "GB", "DE", "FR", "ES");
        System.out.println(list);
        list.add(3, "DE");
        System.out.println(list);
        System.out.println("list.get(3): " + list.get(3));
        System.out.println("list.indexOf(\"DE\"): " + list.indexOf("DE"));
        System.out.println("list.indexOf(\"IE\"): " + list.indexOf("IE"));
        System.out.println("list.subList(1, 5): " + list.subList(1, 5));
        list.remove("DE");
        System.out.println(list);
    }
}