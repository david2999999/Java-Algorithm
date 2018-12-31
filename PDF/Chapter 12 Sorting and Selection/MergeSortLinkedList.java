public class MergeSortLinkedList <E> {
    
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) return;
        
        Queue<K> S1 = new LinkedQueue<>();
        Queue<K> S2 = new LinkedQueue<>();
        
        while(S1.size() < n/2) 
            S1.enqueue(S.dequeue());
            
        while(S2.size() < n/2) 
            S2.enqueue(S.dequeue());
            
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        
        merge(S1, S2, S, comp);
    }
    
    
    public static <E> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while(!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0)
                S.enqueue(S1.dequeue());
            else 
                S.enqueue(S2.dequeue());
        }
        
        while(!S1.isEmpty()) {
            S.enqueue(S1.dequeue()); 
        }
        
        while(!S2.isEmpty()) {
            S.enqueue(S2.dequeue()); 
        }
    }
}