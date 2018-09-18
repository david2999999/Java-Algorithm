package Redo.SystemDesign.SocialNetwork.Servers;

import java.util.HashMap;

public class Server {
    private HashMap<Integer, Machine> machines = new HashMap<>();
    private HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public Machine getMachineWithId(int id) {
        return machines.get(id);
    }

    public int getMachineIdForUser(int personId) {
        Integer machineId = personToMachineMap.get(personId);

        return machineId == null ? -1 : machineId;
    }

    public Person getPersonWithId(int personId) {
        Integer machineId = personToMachineMap.get(personId);
        if (machineId == null) return null;

        Machine machine = getMachineWithId(machineId);
        if (machine == null) return null;

        return machine.getPersonWithId(personId);
    }
}
