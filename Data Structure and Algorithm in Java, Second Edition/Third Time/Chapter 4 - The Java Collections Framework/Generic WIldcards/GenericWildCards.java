public class GenericWildCards {
    public static void print(Collection<?> c) {
        for (Object o: c) {
            System.out.printf("%s", o);
        }
        System.out.println();
    }
}

// The wildcard type can be used more selectively to limit the range of types that can be used in
//its place. For example, if you wanted to restrict the print() method in Example 4.5 to extensions
//of a Person class, then you would replace line 1 with:

//      static void print(Collection<? extends Person> c) {

//The expression ? extends Person is called a bounded wildcard type.