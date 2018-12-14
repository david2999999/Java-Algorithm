public class FavoritesList<E> {
    protected static class Item<E> {
        private E value;
        private int count = 0;
        public Item(E val) {
            value = val;
        }
        
        public int getCount() {
            return count;
        }
        
        public E getValue() {
            return value;
        }
        
        public void increment() {
            count++;
        }
    }
    
    PositionalList<Item<E>> list = new LinkedPositionalList<>();
    public FavoritesList() {}
    
    protected E value(Position<Item<E>> p) {
        return p.getElement().getValue();
    }
    
    protected int count(Position<Item<E>> p) {
        return p.getElement().getCount();
    }
    
    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();
        while (walk != null && !e.equals(value(walk)))
            walk = list.after(walk);
        return walk;
    }
}