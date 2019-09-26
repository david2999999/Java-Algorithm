public class KevinBacon {
    private static final String KEVIN_BACON = "KEVIN BACON";
    private Map<String, ActorGraphNode> actors = new HashMap<>();

    public int findKevinBaconNumber(ActorGraphNode actor) {
        if (actor == null || !actors.containsKey(actor.name)) return -1;

        return actors.get(actor.name).baconNumber;
    }

    public void setBaconNumbers(ActorGraphNode kevinBaconNode) {
        if (kevinBaconNode == null) return;

        kevinBaconNode.baconNumber = 0;
        actors.put(kevinBaconNode.name, kevinBaconNode);

        Queue<ActorGraphNode> queue = new LinkedList<>();
        queue.add(kevinBaconNode);

        ActorGraphNode currentActor;
        while (!queue.isEmpty()) {
            currentActor = queue.poll();

            for (ActorGraphNode adjacentActor: currentActor.adjacentActors) {
                if (adjacentActor.baconNumber != -1) {
                    adjacentActor.baconNumber = currentActor.baconNumber + 1;
                    actors.put(adjacentActor.name, adjacentActor);
                    queue.add(adjacentActor);
                }
            }
        }
    }

    public int findKevinBaconNumberForOneActor(ActorGraphNode actor) {
        if (actor == null) return -1;

        Queue<ActorGraphNode> queue = new LinkedList<>();
        actor.baconNumber = 0;
        queue.add(actor);

        ActorGraphNode current = null;
        while (!queue.isEmpty()) {
            current = queue.poll();

            for (ActorGraphNode adjacentActor: actor.adjacentActors) {
                if (KEVIN_BACON.equalsIgnoreCase(adjacentActor.name)) {
                    return adjacentActor.baconNumber;
                }

                if (adjacentActor.baconNumber != -1) {
                    adjacentActor.baconNumber = current.baconNumber + 1;
                    queue.add(adjacentActor);
                }
            }
        }

        return -1;
    }
}