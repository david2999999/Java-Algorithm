package Redo.OOD.JukeBox;

import ObjectOrientedDesign.Jukebox.Playlist;

public class CDPlayer {
    private CD c;
    private Playlist playlist;

    public CDPlayer(CD c, Playlist playlist) {
        this.c = c;
        this.playlist = playlist;
    }

    public void playSong() {}

    public void playSong(Song song) {}

    public CD getC() {
        return c;
    }

    public void setC(CD c) {
        this.c = c;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
