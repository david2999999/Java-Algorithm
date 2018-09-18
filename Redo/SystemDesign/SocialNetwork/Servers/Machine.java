package Redo.SystemDesign.SocialNetwork.Servers;

import java.util.HashMap;

public class Machine {
    private HashMap<Integer, Person> people;

    public Person getPersonWithId(int personId) {
        return people.get(personId);
    }
}
