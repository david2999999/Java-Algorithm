public class TestEnumSet {
    public static enum Month { JAN, FEB, MAR, APR, MAY, JUN,
        JUL, AUG, SEP, OCT, NOV, DEC }
        
    public static void main(String[] args) {
        EnumSet<Month> spring = EnumSet.range(Month.MAR, Month.JUN);
        System.out.println(spring);
        System.out.println(EnumSet.complementOf(spring));
        EnumSet<Month> shortMonths =
        EnumSet.of(Month.SEP, Month.APR, Month.JUN, Month.NOV, Month.FEB);
        System.out.println(shortMonths);
        shortMonths.addAll(spring);
        System.out.println(shortMonths);
    }
}