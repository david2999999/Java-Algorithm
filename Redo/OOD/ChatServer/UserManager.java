package Redo.OOD.ChatServer;

import java.util.HashMap;

public class UserManager {
    private static UserManager instance;

    private HashMap<Integer, User> users;
    private HashMap<String, User> usersByAccount;
    private HashMap<Integer, User> onlineUsers;

    public static UserManager getInstance() {
        if (instance == null) {
            return new UserManager();
        }

        return instance;
    }


    public void addUser(User fromUser, String toAccountName) {}
    public void approveAddRequest(AddRequest req) {}
    public void rejectAddRequest(AddRequest req) {}
    public void userSignedOff(){}
    public void userSignedOn() {}
}
