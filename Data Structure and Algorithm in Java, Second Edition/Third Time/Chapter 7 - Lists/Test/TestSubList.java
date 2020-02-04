public class TestSubList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        System.out.println(list);
        System.out.println("list.subList(3,8): " + list.subList(3, 8));
        System.out.println("list.subList(3,8).get(2): "
                + list.subList(3, 8).get(2));
        System.out.println("list.subList(3,8).set(2,\"B\"):");
        list.subList(3, 8).set(2, "B");
        System.out.println(list);
        System.out.println("list.indexOf(\"B\"): " + list.indexOf("B"));
        System.out.println("list.subList(3,8).indexOf(\"B\"): "
                + list.subList(3, 8).indexOf("B"));
        System.out.println(list);
        System.out.println("Collections.reverse(list.subList(3,8)):");
        Collections.reverse(list.subList(3, 8));
        System.out.println(list);
        System.out.println("Collections.rotate(list.subList(3,8), 2):");
        Collections.rotate(list.subList(3, 8), 2);
        System.out.println(list);
        System.out.println("Collections.fill(list.subList(3,8), \"X\"):");
        Collections.fill(list.subList(3, 8), "X");
        System.out.println(list);
        list.subList(3, 8).clear();
        System.out.println(list);
    }
}