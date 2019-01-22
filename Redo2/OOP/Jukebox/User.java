package OOP.Jukebox;

public class User {
    private String name;
    private long id;

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public User getUser() {
        return this;
    }

    public static void addUser(String name, long id) {
        // add user to database
        // or hashmap
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
