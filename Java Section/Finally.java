package JavaSection;

public class Finally {
    public static void main(String[] args) {
        bar();
    }

    public static String lem() {
        System.out.println("lem");
        return "return from lem";
    }

    public static String foo() {
        int x = 0;
        int y = 5;
        try {
            System.out.println("start try");
            int b = y / x;
            System.out.println("end try");
            return "returned from try";
        } catch (Exception ex) {
            System.out.println("Catch");
            return lem() + " | returned from scratch";
        } finally {
            System.out.println("finally");
        }
    }

    public static void bar() {
        System.out.println("start bar");
        String v = foo();
        System.out.println(v);
        System.out.println("end bar");
    }
}
