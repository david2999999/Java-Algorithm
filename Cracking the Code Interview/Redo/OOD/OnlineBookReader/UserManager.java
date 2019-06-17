package Redo.OOD.OnlineBookReader;

import java.util.HashMap;

public class UserManager {
    private HashMap<Integer, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public boolean addUser(int id, String details, int accountType) {
        if (users.containsKey(id)) {
            return false;
        }

        User user = new User(id, details, accountType);
        users.put(id, user);
        return true;
    }

    public boolean removeUser(User user) {
        return this.removeUser(user.getUserId());
    }

    public boolean removeUser(int id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }

        return false;
    }

    public User findUser(int id) {
        if (users.containsKey(id)) {
            return users.get(id);
        }

        return null;
    }

}
