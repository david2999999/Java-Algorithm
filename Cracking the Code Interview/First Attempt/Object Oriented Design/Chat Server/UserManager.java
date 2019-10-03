package ObjectOrientedDesign.ChatServer;

import java.util.HashMap;

public class UserManager {
    private static UserManager instance;
    private HashMap<Integer, User> usersById;
    private HashMap<String, User> userByAccountName;
    private HashMap<Integer, User> onlineUsers;

    private static UserManager getInstance() {
        if (instance == null) instance = new UserManager();
        return instance;
    }

    public void addUser(User fromUser, String toAccountName){}
    public void approveAddRequest(AddRequest addRequest) {}
    public void rejectAddRequest(AddRequest addRequest) {}
    public void userSignedOff(String accountName) {}
    public void userSignedOn(String accountName) {}
}
