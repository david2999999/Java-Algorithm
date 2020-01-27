public class InclusionPolymorphism {
    public static void main(String[] args) {
        Ratio x = new Ratio(22, 7);
        System.out.println("x.hashCode(): " + x.hashCode());
    }
}


// There are several kinds of polymorphism. The simplest kind is called inclusion polymorphism;
// it refers to the ability of an object to invoke a method that it inherits.