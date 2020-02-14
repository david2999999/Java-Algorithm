public class KeyFinder {
    public static boolean isKeyInTheBox(Box bigBox) {
        if (bigBox == null || bigBox.isEmpty()) {
            return false;
        }

        Queue<Item> queue = new LinkedList<>();
        queue.add(bigBox);

        Item currentItem = null;
        while(!queue.isEmpty()) {
            currentItem = queue.poll();

            if (currentItem.hasKey()) {
                return true;
            }

            if (currentItem instanceof Box) {
                for (Item item: ((Box) currentItem).getItems()) {
                    queue.add(item);
                }
            }
        }

        return false;
    }
}