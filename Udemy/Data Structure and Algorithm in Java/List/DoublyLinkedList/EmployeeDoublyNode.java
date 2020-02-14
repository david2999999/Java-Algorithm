package List.DoublyLinkedList;

import List.ArrayList.Employee;
import List.SinglyList.EmployeeNode;

public class EmployeeDoublyNode {
    private Employee employee;
    private EmployeeDoublyNode next;
    private EmployeeDoublyNode prev;

    public EmployeeDoublyNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDoublyNode getNext() {
        return next;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(EmployeeDoublyNode next) {
        this.next = next;
    }

    public EmployeeDoublyNode getPrev() {
        return prev;
    }

    public void setPrev(EmployeeDoublyNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "EmployeeNode{" +
                "employee=" + employee +
                '}';
    }
}
