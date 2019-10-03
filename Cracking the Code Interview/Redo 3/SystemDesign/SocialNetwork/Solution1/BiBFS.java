package SystemDesign.SocialNetwork.Solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BiBFS {
    public LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);

            if (collision != null) {
                return mergePath(sourceData, destData, collision.getID());
            }

            collision = searchLevel(people, destData, sourceData);

            if (collision != null) {
                return mergePath(sourceData, destData, collision.getID());
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

    private Person searchLevel(HashMap<Integer,Person> people, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();

        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getID();

            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId: friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }

        return null;
    }
}











