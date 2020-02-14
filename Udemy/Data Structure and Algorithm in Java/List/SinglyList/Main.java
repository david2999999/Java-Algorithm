package List.SinglyList;

import List.ArrayList.Employee;

public class Main {
    public static void main(String[] args) {

        Employee employee =  new Employee("Jane", "Jones", 123);
        Employee employee1 = new Employee("John", "Doe", 1233);
        Employee employee2 = new Employee("John", "Smith", 2153);
        Employee employee3 = new Employee("Mike", "Wilson", 5122);
        Employee employee4 = new Employee("Mary", "Smith", 125123);
        Employee employee5 = new Employee("Steve", "Jones", 63242);

        EmployeeLinkedList list = new EmployeeLinkedList();
        System.out.println(list.isEmpty());
        list.addToFront(employee);
        list.addToFront(employee1);
        list.addToFront(employee2);
        list.addToFront(employee3);
        list.addToFront(employee4);
        list.addToFront(employee5);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }
}
