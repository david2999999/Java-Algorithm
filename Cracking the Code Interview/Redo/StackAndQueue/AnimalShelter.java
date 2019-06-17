package Redo.StackAndQueue;

import java.util.LinkedList;

public class AnimalShelter {
    private class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }
    }

    private class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }
    }

    private LinkedList<Dog> dogs;
    private LinkedList<Cat> cats;
    private int order = 0;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        if (animal == null) return;

        animal.setOrder(order++);

        if (animal instanceof Dog) {
            dogs.addLast((Dog)animal);
        } else {
            cats.addLast((Cat)animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        }

        Animal dog = dogs.peek();
        Animal cat = cats.peek();

        if (dog.olderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }

    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }
}
