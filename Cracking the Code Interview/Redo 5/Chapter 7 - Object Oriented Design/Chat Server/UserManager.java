public class UserManager {
    private static UserManager instance;

    private HashMap<Integer, User> usersById;
    private HashMap<String, User> usersByAccountName;
    private HashMap<Integer, User> onlineUsers;

    public synchronized static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public void addUser(User fromUser, String toAccountName) {}
    public void approveAddRequest(AddRequest req) {}
    public void rejectAddRequest(AddRequest req) {}
    public void userSignedOn(String accountName) {}
    public void userSignedOff(String accountName) {}
}