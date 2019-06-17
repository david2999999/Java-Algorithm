package Redo.OOD.ChatServer;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private UserStatus userStatus;

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

    public boolean sendMessageToUser(User to, String content) {
        // get or create private chat
        // add the two users, this and to
        // add the string content
        return true;
    }

    public boolean sendMessageToGroupChat(int id, String content) {
        // find the group chat id
        // add the message to the group
        return true;
    }

    public boolean addUserToContact(User user) {
        // check if the hashmap contains the user
        // if found return false
        // else add the user to hashmap with the user id
        return true;
    }

    public void recieveAddRequest(AddRequest request) {

    }

    public void sendAddRequest(AddRequest request) {

    }

    public void addConversation(Conversation conversation) {
        if (conversation instanceof PrivateChat) {
            privateChats.put(conversation.id, (PrivateChat) conversation);
        } else if (conversation instanceof GroupChat) {
            groupChats.add((GroupChat) conversation);
        }
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public int getId() {
        return id;
    }
}
