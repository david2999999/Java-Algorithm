package SystemDesign.SocialNetwork.Solution2;

import java.util.HashMap;

public class Server {
    private HashMap<Integer, Machine> machines = new HashMap<>();
    private HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public Machine getMachineWithId(int machineId) {
        return machines.get(machineId);
    }

    public int getMachineIdForUser(int personId) {
        Integer machineId = personToMachineMap.get(personId);
        return machineId == null ? -1 : machineId;
    }

    public Person getPersonWithId(int personId) {
        Integer machineId = personToMachineMap.get(personId);
        if (machineId == null) return null;

        Machine machine = getMachineWithId(machineId);

        return machine.getPersonWithId(personId);
    }
}
