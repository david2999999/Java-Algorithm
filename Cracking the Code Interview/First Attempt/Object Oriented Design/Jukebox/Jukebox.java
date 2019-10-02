package ObjectOrientedDesign.Jukebox;

import java.util.Set;

public class Jukebox {
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector songSelector;

    public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector songSelector) {
        this.cdPlayer = cdPlayer;
        this.user = user;
        this.cdCollection = cdCollection;
        this.songSelector = songSelector;
    }

    public Song getCurrentSong() {
        return songSelector.getCurrentSong();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
