package List.DoublyLinkedList;

import List.ArrayList.Employee;
import List.SinglyList.EmployeeNode;

public class EmployeeDoublyLinkedList {
    private EmployeeDoublyNode head;
    private EmployeeDoublyNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        node.setNext(head);

        if (head == null)
            tail = node;
        else
            head.setPrev(node);

        head = node;
        size++;
    }

    public EmployeeDoublyNode removeFromFront() {
        if (isEmpty()) return null;

        EmployeeDoublyNode removedNode = head;
        head = head.getNext();
        size--;

        removedNode.setNext(null);
        return removedNode;
    }

    public void printList() {
        EmployeeDoublyNode current = head;

        System.out.print("Head -> ");
        while (current != null) {
            System.out.println(current);
            System.out.println(" <=> ");
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
