public class Acyclic {
    public boolean isAcyclic(Element head) {
        if (head == null) return false;

        Element fast = head;
        Element slow = head;

        while (fast != null && fast.next != null) {
            if (fast == slow || fast.next == slow) return true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}