public class InsertionSortLinkedList {
    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        while(marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            
            if (value > marker.getElement()) {
                marker = pivot; // position is already sorted
            } else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value) {
                    walk = list.before(walk);
                }
                
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}