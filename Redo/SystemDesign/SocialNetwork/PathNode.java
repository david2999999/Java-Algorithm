package Redo.SystemDesign.SocialNetwork;

import java.util.LinkedList;

public class PathNode {
    private Person person = null;
    private PathNode previousNode = null;

    public PathNode(Person person, PathNode previousNode) {
        this.person = person;
        this.previousNode = previousNode;
    }

    public Person getPerson() {
        return person;
    }

    public LinkedList<Person> collapse(boolean startWithRoot) {
        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;

        while (node != null) {
            if (startWithRoot) {
                path.addLast(node.getPerson());
            } else {
                path.addFirst(node.getPerson());
            }

            node = node.previousNode;
        }

        return path;
    }
}
