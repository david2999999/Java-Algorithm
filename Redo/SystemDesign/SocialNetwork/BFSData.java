package Redo.SystemDesign.SocialNetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
    public Queue<PathNode> toVisit = new LinkedList<>();
    public HashMap<Integer, Person> visited = new HashMap<>();

    public BFSData(Person root) {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root.getId(), root);
    }

    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}
