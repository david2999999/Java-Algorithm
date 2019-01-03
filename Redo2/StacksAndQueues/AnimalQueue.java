package StacksAndQueues;

import java.util.LinkedList;

// an animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis
// people must adopt either the oldest animal based on arrival time of all animals or they can select whether
// they would prefer a dog or a cat (and will receive the oldest of that type)
// create a data structure to maintain this system
public class AnimalQueue {
    // creating an private inner abstract animal class
    private static abstract class Animal {
        private int order;  // an id to keep track the order of the animal
        protected String name;  // aesthetic purpose

        public Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.order;    // the lower the order/id, the older the animal
        }
    }

    private static class Dog extends Animal {
        public Dog(String n) {
            super(n);
        }
    }

    private static class Cat extends Animal {
        public Cat(String n) {
            super(n);
        }
    }

    // You can move the animal class to a different file for more maintainable code
    // Queue implementation starts here.

    // 2 list to keep track of the animals
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;  // acts as a timestamp or id for the animals that comes in

    public void enqueue(Animal a) {
        a.setOrder(order++);    // give the animal a timestamp and increment the timestamp
        if (a instanceof Dog) dogs.addLast((Dog)a); // if it is a dog add to dogs list
        else if (a instanceof Cat) cats.addLast((Cat)a); // if it is a cat add to cats list
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) { // if there are no dogs
            return dequeueCats();   // get a cat from the cats list
        } else if (cats.size() == 0) {  // if there are no cats
            return dequeueDogs();   // get a dog from the dogs list
        }

        // if both lists has an animal - we will choose the oldest animal based on its order
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) { // if the dog is older
            return dequeueDogs();   // get the dog
        } else {
            return dequeueCats();   // else get the cat
        }
    }

    private Dog dequeueDogs() {
        return dogs.poll();
    }

    private Cat dequeueCats() {
        return cats.poll(); // get a cat from the beginning of the list
    }
}


















