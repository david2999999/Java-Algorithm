public class CostPerformanceDatabase {
    SortedMap<Integer, Integer> map = new SortedMap<>();

    public CostPerformanceDatabase() {}

    public Entry<Integer, Integer> best(int cost) {
        return map.floorEntry(cost);
    }

    public void add(int cost, int performance) {
        Entry<Integer, Integer> other = map.floorEntry(c);
        if (other != null && other.getValue() >= performance) {
            return;
        }

        map.put(cost, performance);

        other = map.higherEntry(c);
        while (other != null && other.getValue() <= performance) {
            map.remove(other.getKey());
            other = map.higherEntry(c);
        }
    }
}