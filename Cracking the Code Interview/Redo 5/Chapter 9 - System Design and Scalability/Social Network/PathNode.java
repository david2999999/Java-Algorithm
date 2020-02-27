public class PathNode {
    private Person person = null;
    private PathNode previousNode = null;

    public PathNode(Person p, PathNode previous) {
        person = p;
        previousNode = previous;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;

        while (node != null) {
            if (startWithRoot) {
                path.addLast(node.person);
            } else {
                path.addFirst(node.person);
            }

            node = node.previousNode;
        }

        return path;
    }
}