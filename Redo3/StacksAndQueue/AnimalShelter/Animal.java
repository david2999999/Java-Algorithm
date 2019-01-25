package StacksAndQueue.AnimalShelter;

public abstract class Animal {
    private int order;
    protected String name;

    public Animal(String n) {
        name = n;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
