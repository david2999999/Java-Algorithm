package ObjectOrientedDesign.ChatServer;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private UserStatus status = null;

    private HashMap<Integer, PrivateChat> privateChats;
    private ArrayList<GroupChat> groupChats;

    private HashMap<Integer, AddRequest> receivedAddRequests;
    private HashMap<Integer, AddRequest> sentAddRequests;

    private HashMap<Integer, User> contacts;

    private String accountName;
    private String fullName;

    public User(int id, String accountName, String fullName) {
        this.id = id;
        this.accountName = accountName;
        this.fullName = fullName;
    }


    // methods include
    // sent messages to user
    // sent message to group
    // add contact
    // receive add request
    // sent add request
    // remove add request
    // remove user
    // add conversation for group chat
    // add conversation for private chat

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getFullName() {
        return fullName;
    }
}
