public abstract class Animal {
    private int order;
    protected String name;

    public Animal(String n) {
        this.name = n;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }
}