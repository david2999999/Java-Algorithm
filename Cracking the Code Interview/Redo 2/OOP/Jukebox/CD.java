package OOP.Jukebox;

import java.util.ArrayList;

public class CD {
    private long id;
    private String artist;
    private ArrayList<Song> songs;

    public CD(long id, String artist) {
        this.id = id;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
