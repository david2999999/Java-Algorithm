public class TestingSeveralIterators {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, "A", "B", "C", "D");
        System.out.println(list);
        ListIterator<String> it1 = list.listIterator();
        System.out.println("it1.next(): " + it1.next());
        System.out.println("it1.next(): " + it1.next());
        System.out.println("it1.next(): " + it1.next());
        System.out.println("it1.add(\"X\"):");
        it1.add("X");
        System.out.println(list);
        ListIterator<String> it2 = list.listIterator();
        System.out.println("it2.next(): " + it2.next());
        System.out.println("it2.next(): " + it2.next());
        System.out.println("it2.set(\"Y\"):");
        it2.set("Y");
        System.out.println(list);
        ListIterator<String> it3 = list.listIterator();
        System.out.println("it3.next(): " + it3.next());
        System.out.println("it3.next(): " + it3.next());
        System.out.println("it3.next(): " + it3.next());
        System.out.println("it3.next(): " + it3.next());
        System.out.println("it1.previous(): " + it1.previous());
        System.out.println("it1.previous(): " + it1.previous());
        System.out.println("it1.previous(): " + it1.previous());
    }
}