package Hard2.WordTransformer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {
    public Queue<PathNode> toVisit = new LinkedList<>();
    public HashMap<String, PathNode> visited = new HashMap<>();

    public BFSData(String root) {
        // previous node is null because this is the starting node
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root, sourcePath);  // add to visited map
    }

    // check if we have finish BFS
    public boolean isFinished() {
        return toVisit.isEmpty();
    }
}
