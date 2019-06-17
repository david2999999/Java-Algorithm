package SystemDesign.SocialNetwork;

import java.util.HashMap;

public class Machine {
    HashMap<Integer, Person> people;

    public Machine(HashMap<Integer, Person> people) {
        this.people = people;
    }

    public Person getPersonWithId(int personId) {
        return this.people.get(personId);
    }
}
