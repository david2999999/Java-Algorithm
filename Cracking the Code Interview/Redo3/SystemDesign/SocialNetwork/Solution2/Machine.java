package SystemDesign.SocialNetwork.Solution2;

import java.util.HashMap;

public class Machine {
    private HashMap<Integer, Person> people;

    public Person getPersonWithId(int id) {
        return people.get(id);
    }
}
