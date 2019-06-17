package Redo.StackAndQueue;

public abstract class Animal {
    private int order = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean olderThan(Animal animal) {
        return this.order < animal.order;
    }
}
