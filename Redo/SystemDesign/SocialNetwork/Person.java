package Redo.SystemDesign.SocialNetwork;

import java.util.ArrayList;

public class Person {
    private int id;
    private ArrayList<Integer> friends;

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getId() {
        return id;
    }
}
