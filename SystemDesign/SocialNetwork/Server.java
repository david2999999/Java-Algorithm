package SystemDesign.SocialNetwork;

import java.util.HashMap;

public class Server {
    HashMap<Integer, Machine> machines = new HashMap<>();
    HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public HashMap<Integer, Machine> getMachines() {
        return machines;
    }

    public int getMachineIdForUser(int personId) {
        Integer machineId = personToMachineMap.get(personId);
        return machineId == null ? -1 : machineId;
    }

    public Person getPersonWithId(int personId) {
        Integer machineId = personToMachineMap.get(personId);
        if (machineId == null) return null;

        Machine machine = machines.get(machineId);
        if (machine == null) return null;

        return machine.getPersonWithId(personId);
    }
}
