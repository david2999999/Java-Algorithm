package SystemDesign.SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FindPathByBFS {
    private LinkedList<Person> findPathBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getId());
            }

            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getId());
            }
        }

        return null;
    }

    private Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();

        for ( int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getId();

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

    LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);

        LinkedList<Person> path1 = end1.collapse(false);
        LinkedList<Person> path2 = end2.collapse(true);
        path2.removeFirst();
        path1.addAll(path2);

        return path1;
    }
}
