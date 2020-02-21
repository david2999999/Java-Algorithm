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

    public User(int id, String accountName, String fullName) {}

    public boolean sendMessageToUser(User to, String content) {}

    public boolean sendMessageToGroupChat(int id, String cnt) {}

    public void setStatus(UserStatus status) { }

    public UserStatus getStatus() {}

    public boolean addContact(User user) {}

    public void receivedAddRequest(AddRequest req) {}

    public void sentAddRequest(AddRequest req) {}

    public void removeAddRequest(AddRequest req) {}

    public void requestAddUser(String accountName) { }

    public void addConversation(PrivateChat conversation) { }

    public void addConversation(GroupChat conversation) { }

    public int getld() {}

    public String getAccountName() {}

    public String getFullName() {}
}
