public class DeleteDuplicates {
    public void deleteDups(LinkedListNode node) {
        HashSet<Integer> set = new Hashset<Integer>();  // need to ask what kind of data is inside the node
        LinkedListNode prev = null;

        while (node != null) {
            if (set.contains(node.data)) {
                prev.next = node.next;
            } else {
                set.put(node.data);
                prev = node;
            }

            node = node.next;
        }
    }
}