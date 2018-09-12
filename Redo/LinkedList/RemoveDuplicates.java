package Redo.LinkedList;

import CodeLibrary.LinkedListNode;

import java.util.HashSet;

public class RemoveDuplicates {
    private void removeDuplicatesWithHashMap(LinkedListNode node) {
        HashSet<Integer> nodes = new HashSet<>();
        LinkedListNode previous = new LinkedListNode();

        while (node != null) {
            if (nodes.contains(node.data)) {
                previous.next = node.next;
            } else {
                nodes.add(node.data);
                previous = node;
            }

            node = node.next;
        }
    }

    private void removeDuplicatesWithoutBuffer(LinkedListNode head) {
        LinkedListNode current = head;

        while (current != null) {
            LinkedListNode runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            current = current.next;
        }
    }
}
