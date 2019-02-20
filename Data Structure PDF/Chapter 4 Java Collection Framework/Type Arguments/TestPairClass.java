public class TestPairClass {
    public static void main(String[] args) {
        Pair<Month, Integer> christmas = new Pair<Month,Integer>(Month.DEC, 25);
        System.out.println(christmas);
        Month month = christmas.getFirst();
        int day = christmas.getSecond();
        System.out.printf("%d %s%n", day, month);
    }
}