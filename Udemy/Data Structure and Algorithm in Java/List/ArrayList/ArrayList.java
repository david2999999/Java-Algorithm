package List.ArrayList;

public class ArrayList {
    public static void main(String[] args) {
        java.util.ArrayList<Employee> employeeList = new java.util.ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 1233));
        employeeList.add(new Employee("John", "Smith", 2153));
        employeeList.add(new Employee("Mike", "Wilson", 5122));
        employeeList.add(new Employee("Mary", "Smith", 125123));
        employeeList.add(new Employee("Steve", "Jones", 63242));

        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println();
        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 24212));
        System.out.println();
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.size());
        System.out.println();

        employeeList.add(3, new Employee("Qwert", "Las", 124));
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println();
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee: employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("Jane", "Jones", 123)));
        System.out.println(employeeList.indexOf(new Employee("John", "Adams", 24212)));

        System.out.println();
        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));

    }
}
