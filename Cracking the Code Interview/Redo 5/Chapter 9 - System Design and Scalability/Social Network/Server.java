public class Server {
    private HashMap<Integer, Machine> machines = new HashMap<>();
    private HashMap<Integer, Integer> personToMachineMap = new HashMap<>();

    public Machine getMachineWithId(int machineID) {
        return machines.get(machineID);
    }

    public int getMachineIdForUser(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        return machineID == null ? -1 : machineID;
    }

    public Person getPersonWithID(int personID) {
        Integer machineID = personToMachineMap.get(personID);
        if (machineID == null) {
            return null;
        }

        Machine machine = getMachineWithId(machineID);
        return machine != null ? machine.getPersonWithID(personID) : null;
    }
}