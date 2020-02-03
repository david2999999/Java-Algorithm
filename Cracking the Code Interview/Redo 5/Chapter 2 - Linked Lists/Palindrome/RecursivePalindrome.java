public class RecursivePalindrome {
    private static class Result {
        public boolean isPalindrome;
        public LinkedListNode node;

        public Result(LinkedListNode node, boolean isPalindrome) {
            this.node = node;
            this.isPalindrome = isPalindrome;
        }
    }

    public boolean isPalindrome(LinkedListNode node) {
        int length = length(node);
        Result result = isPalindromeRecurse(node, length);
        return result.isPalindrome;
    }

    private Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) {
            return Result(head, true);
        } else if (length == 1) {
            return Result(head.next, true);
        }

        LinkedListNode result = isPalindromeRecurse(head, length - 2);

        if (!result.isPalindrome || result.node == null) return result;

        result.isPalindrome = result.node.data == head.data;
        result.node = result.node.next;
        return result;
    }



    private int length(LinkedListNode node) {
        int length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}