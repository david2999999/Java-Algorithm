package Redo.OOD.JukeBox;

import java.util.Set;

public class JukeBox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> collection;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> collection) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.collection = collection;
    }

    public void playSong() {
        cdPlayer.playSong();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
