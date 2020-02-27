public class SocialNetwork {
    private HashMap<Integer, Person> people;

    public SocialNetwork(HashMap<Integer, Person> people) {
        this.people = people;
    }

    public LinkedList<Person> findPathBidirectionalBFS(int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            Person collision = searchLevel(sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }

            collision = searchLevel(destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }

        return null;
    }

    private Person searchLevel(BFSData primary, BFSData secondary) {
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson.getID();

            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId: friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = person.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }

        return null;
    }
}