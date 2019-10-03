package SystemDesign.SocialNetwork.Solution1;

import java.util.ArrayList;

public class Person {
    private int ID;
    private ArrayList<Integer> friends;

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return ID;
    }
}
