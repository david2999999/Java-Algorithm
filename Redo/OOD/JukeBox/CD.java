package Redo.OOD.JukeBox;

import java.util.ArrayList;

public class CD {
    private ArrayList<Song> songs;

    public CD() {
        this.songs = new ArrayList<>();
    }

    private void addSong(Song song) {
        songs.add(song);
    }

    private void addSongs(ArrayList<Song> songs) {
        this.songs.addAll(songs);
    }
}
