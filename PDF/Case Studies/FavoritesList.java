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
}