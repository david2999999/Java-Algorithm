public class KevinBacon {
    private static final String KEVIN_BACON = "KEVIN BACON";

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