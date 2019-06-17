package OOP.Jukebox;

import java.util.Set;

public class Jukebox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
