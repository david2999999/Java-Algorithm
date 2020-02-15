public class LinkedList {
    public static LinkedListNode getIthItem(LinkedListNode head, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Unable to retrieve value at negative index");
        }

        LinkedListNode currentNode = head;
        int currentPosition = 0;

        while (currentNode != null) {
            if (currentPosition == i) {
                return currentNode;
            }

            currentNode = currentNode.next;
            currentPosition++;
        }

        return null;
    }
}