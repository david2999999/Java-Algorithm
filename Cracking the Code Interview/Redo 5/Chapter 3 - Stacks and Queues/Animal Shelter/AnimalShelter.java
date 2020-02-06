public class AnimalShelter {
    private int order = 0;
    private Queue<Dog> dogs = new LinkedList<>();
    private Queue<Cat> cats = new LinkedList<>();

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) dogs.add((Dog) animal);
        if (animal instanceof Cat) cats.add((Cat) animal);
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        return dog.isOlderThan(cat) ? dequeueDog() : dequeueCat();
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}