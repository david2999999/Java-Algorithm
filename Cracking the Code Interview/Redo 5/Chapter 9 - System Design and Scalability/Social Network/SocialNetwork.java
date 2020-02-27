public class SocialNetwork {
    private HashMap<Integer, Person> people;

    public SocialNetwork(HashMap<Integer, Person> people) {
        this.people = people;
    }

    public LinkedList<Person> findPathBidirectionalBFS(int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }

            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }

        return null;
    }
}