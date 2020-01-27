public class ParametricPolymorphism {
    public static void main(String[] args) {
        String[] countries = {
                "CN", "IN", "US", "ID", "BR"
        };
        print(countries);

        Ratio ratios = new Ratio[3];
        ratios[0] = new Ratio(22, 7);
        ratios[1] = new Ratio(25, 8);
        ratios[2] = new Ratio(28, 9);
        print(ratios);
    }

    private <T> static void print(T[] a) {
        for (T t: a) {
            System.out.printf("%s", t);
        }

        System.out.println();
    }
}

// The print() method defined at line 15 is a generic method. It uses the type parameter T as a placeholder
// for an actual type, which will be determined at run time. When the generic method is invoked at
// lines 6 and 12, the type String is used in place of T. When it is invoked at lines 12, the type Ratio
//is used. This makes the method polymorphic, capable of printing arrays of String objects and arrays of
//Ratio objects.