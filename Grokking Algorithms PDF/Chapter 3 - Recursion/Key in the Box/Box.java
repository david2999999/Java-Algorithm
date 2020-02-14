public class Box implements Item {
    private boolean hasKey;
    private List<Item> items;

    public Box(boolean hasKey) {
        this.hasKey = hasKey;
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public boolean hasKey() {
        return hasKey;
    }
}
