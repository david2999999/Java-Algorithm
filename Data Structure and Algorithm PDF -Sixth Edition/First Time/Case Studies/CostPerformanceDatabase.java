public class CostPerformanceDatabase {
    SortedMap<Integer,Integer> map = new SortedTableMap<>();
    
    public CostPerformanceDatabase() { }
    
    public Entry<Integer,Integer> best(int cost) {
        return map.floorEntry(cost);
    }
    
    public void add(int c, int p) {
        Entry<Integer,Integer> other = map.floorEntry(c);
        if (other != null && other.getValue() >= p)
            return;
            
        map.put(c, p);
        
        other = map.higherEntry(c);
        
        while (other != null && other.getValue( ) <= p) {
            map.remove(other.getKey());
            other = map.higherEntry(c);
        }
    }
}