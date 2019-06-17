package StackAndQueues;

import java.util.LinkedList;

public class AnimalShelter {
    public abstract class Animal {
        private int order;
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean isOlderThan(Animal animal) {
            return this.order < animal.getOrder();
        }
    }

    public class AnimalQueue {
        private LinkedList<Dog> dogs = new LinkedList<>();
        private LinkedList<Cat> cats = new LinkedList<>();
        private int order;

        public void enqueue(Animal animal) {
            animal.setOrder(order);
            order++;

            if (animal instanceof Dog) {
                dogs.addLast((Dog)animal);
            } else if (animal instanceof Cat) {
                cats.addLast((Cat)animal);
            }
        }

        public Animal deQueue() {
            if (dogs.size() == 0) {
                return deQueueCats();
            } else if (cats.size() == 0) {
                return deQueueDogs();
            }

            Dog dog = dogs.peek();
            Cat cat = cats.peek();

            if (dog.isOlderThan(cat)) {
                return deQueueDogs();
            } else {
                return deQueueCats();
            }
        }

        private Animal deQueueDogs() {
            return dogs.poll();
        }

        private Animal deQueueCats() {
            return cats.poll();
        }

    }


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
}
