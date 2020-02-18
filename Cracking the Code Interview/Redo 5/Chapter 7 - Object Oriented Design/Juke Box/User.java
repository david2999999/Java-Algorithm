public class User {
    private String name;
    private long ID;

    public User(String name, long iD) {}

    public User getuser() {
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID (long iD) {
        ID = iD;
    }

    public static User addUser(String name, long iD) {}
}
