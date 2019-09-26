public class ActorGraphNode {
    public Set<ActorGraphNode> adjacentActors;
    public String name;
    public int baconNumber;

    public ActorGraphNode(String name) {
        this.name = name;
        this.baconNumber = -1;
        this.adjacentActors = new HashSet<ActorGraphNode>();
    }
}
