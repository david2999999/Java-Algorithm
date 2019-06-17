package Redo.OOD.JukeBox;

public class Song {
    private String name;
    private double duration;
    private Artist artist;

    public Song(String name, double duration, Artist artist) {
        this.name = name;
        this.duration = duration;
        this.artist = artist;
    }
}
