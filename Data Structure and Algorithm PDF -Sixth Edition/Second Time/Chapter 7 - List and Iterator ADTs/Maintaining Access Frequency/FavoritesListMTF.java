public class FavoritesListMTF<E> extends FavoritesList<E> {
    protected void moveUp(Position<Item<E>> p) {
        if (p != list.first()) {
            list.addFirst(list.remove(p));
        }
    }

    public iterable<E> getFavorites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Invalid k");

        PositionalList<Item<E>> temp = new LinkedPositionalList<>();
        for (Item<E> item: list) {
            temp.addLast(item);
        }

        PositionalList<E> result = new LinkedPositionalList<>();
        for (int j = 0; j < k; j++) {
            Position<Item<E>> highPos = temp.first();
            Position<Item<E>> walk = temp.after(highPos);

            while (walk != null) {
                if (count(walk) > count(highPos)) {
                    walk = highPos;
                }

                walk = temp.after(walk);
            }

            result.addLast(value(highPos));
            temp.remove(highPos);
        }

        return result;
    }
}