package SystemDesign.Cache;

public class Node {
    public String query;
    public String[] results;


    public Node(String query, String[] results) {
        this.query = query;
        this.results = results;
    }
}
