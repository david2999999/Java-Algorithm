package LinkedList;

import java.util.HashSet;

public class RemovingDuplicates {
    public static void main(String[] args) {

    }

    private static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }

            n = n.next;
        }
    }

}
