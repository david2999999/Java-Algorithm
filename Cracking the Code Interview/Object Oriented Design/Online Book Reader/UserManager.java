package ObjectOrientedDesign.OnlineBookReader;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType) {
        if (users.containsKey(id)) {
            return null;
        }

        User user = new User(id, details, accountType);
        this.users.put(id, user);

        return user;
    }

    public User find(int id) { return users.get(id); }
    public boolean remove(User u) { return remove(u.getUserId()); }
    public boolean remove(int id) {
        if (!this.users.containsKey(id)) return false;

        this.users.remove(id);
        return true;
    }
}
