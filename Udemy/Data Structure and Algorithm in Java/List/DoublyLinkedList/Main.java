package List.DoublyLinkedList;

import List.ArrayList.Employee;
import List.SinglyList.EmployeeLinkedList;

public class Main {
    public static void main(String[] args) {
        Employee employee =  new Employee("Jane", "Jones", 123);
        Employee employee1 = new Employee("John", "Doe", 1233);
        Employee employee2 = new Employee("John", "Smith", 2153);
        Employee employee3 = new Employee("Mike", "Wilson", 5122);
        Employee employee4 = new Employee("Mary", "Smith", 125123);
        Employee employee5 = new Employee("Steve", "Jones", 63242);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(employee);
        list.addToFront(employee1);
        list.addToFront(employee2);
        list.addToFront(employee3);
        list.addToFront(employee4);
        list.addToFront(employee5);

        list.printList();
    }
}
