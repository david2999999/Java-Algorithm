public class FavoritesListMTF<E> extends FavoritesList<E> {
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first()) 
            list.addFirst(list.remove(p));
    }
    
    
}