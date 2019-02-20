 public class TestIterators {
     public static void main(String[] args) {
         Set<String> port = new HashSet<String>();
         Collections.addAll(port, "AO", "BR", "CV", "GW", "MO", "MZ", "PT");
         System.out.println(port);
         Iterator it1 = port.iterator();
         System.out.printf("it1.next(): %s%n", it1.next());
         System.out.printf("it1.next(): %s%n", it1.next());
         System.out.printf("it1.next(): %s%n", it1.next());
         System.out.printf("it1.next(): %s%n", it1.next());
         it1.remove();
         System.out.println(port);
         System.out.printf("it1.next(): %s%n", it1.next());
         it1.remove();
         System.out.println(port);
         
         Iterator it2 = port.iterator();
         while(it2.hasNext()) {
            System.out.printf("%s ", it2.next());
         }
         
         System.out.println("");
         System.out.printf("it1.next(): %s%n", it1.next());
    }
 }