package List.SinglyList;

import List.ArrayList.Employee;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) return null;

        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;

        removedNode.setNext(null);
        return removedNode;
    }

    public void printList() {
        EmployeeNode current = head;

        System.out.print("Head -> ");
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
