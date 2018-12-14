package List;

import List.ArrayList.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedList {
    public static void main(String[] args) {
        Employee employee =  new Employee("Jane", "Jones", 123);
        Employee employee1 = new Employee("John", "Doe", 1233);
        Employee employee2 = new Employee("John", "Smith", 2153);
        Employee employee3 = new Employee("Mike", "Wilson", 5122);
        Employee employee4 = new Employee("Mary", "Smith", 125123);
        Employee employee5 = new Employee("Steve", "Jones", 63242);
        Employee billEnd = new Employee("Bill", "End", 12);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(employee);
        list.addFirst(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);
        list.addFirst(employee4);
        list.addFirst(employee5);

        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        list.addLast(billEnd);

        System.out.println();
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


        list.removeFirst();

        System.out.println();
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }


        list.removeLast();

        System.out.println();
        iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
