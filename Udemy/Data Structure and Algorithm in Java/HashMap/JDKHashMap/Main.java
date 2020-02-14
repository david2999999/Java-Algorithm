package HashMap.JDKHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        //Employee employee = hashMap.put("Doe", mikeWilson);
        Employee employee = hashMap.putIfAbsent("Doe", mikeWilson);
        System.out.println(employee);

        System.out.println(hashMap.getOrDefault("someone", mikeWilson));

        System.out.println(hashMap.remove("Jones"));

//        System.out.println(hashMap.containsKey("Doe"));
//        System.out.println(hashMap.containsValue(janeJones));

//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + ", Employee = " + v));

    }
}
