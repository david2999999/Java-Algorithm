package Redo.SystemDesign.SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FindPathBF {
    private LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int dest) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(dest));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = findPath(people, sourceData, destData);

            if (collision != null) {
                return mergePath(sourceData, destData, collision.getId());
            }

            collision = findPath(people, destData, sourceData);

            if (collision != null) {
                return mergePath(sourceData, destData, collision.getId());
            }
        }

        return null;

    }

    private LinkedList<Person> mergePath(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);

        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true);

        pathTwo.removeFirst();
        pathOne.addAll(pathTwo);
        return pathOne;

    }

    private Person findPath(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();

        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getId();

            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();

            for (int id: friends) {
                Person friend = people.get(id);
                PathNode next = new PathNode(friend, pathNode);
                primary.toVisit.add(next);
                primary.visited.put(friend.getId(), next);
            }
        }

        return null;
    }

}
