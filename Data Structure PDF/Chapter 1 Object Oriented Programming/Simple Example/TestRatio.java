public class TestRatio {
    public static void main(String[] args) {
        System.out.println("Ratio.ZERO = " + Ratio.ZERO);
        System.out.println("Ratio.ZERO.value() = " + Ratio.ZERO.value());
        Ratio x = new Ratio(22, 7);
        System.out.println("x = " + x);
        System.out.println("x.value() = " + x.value());
        System.out.println("x.equals(Ratio.ZERO): " + x.equals(Ratio.ZERO));
        Ratio xx = new Ratio(44, 14);
        System.out.println("xx = " + xx);
        System.out.println("xx.value() = " + xx.value());
        System.out.println("x.equals(xx): " + x.equals(xx));
    }
}