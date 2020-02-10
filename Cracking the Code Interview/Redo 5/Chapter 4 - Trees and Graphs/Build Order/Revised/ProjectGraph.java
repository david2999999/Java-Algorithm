public class ProjectGraph extends AbstractGraph {
    protected Node createCustomNode(String name) {
        return new ProjectNode(name);
    }
}