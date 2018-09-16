package Redo.OOD.JukeBox;

import java.util.Queue;

public class PlayList {
    private Song song;
    private Queue<Song> songs;

    public PlayList(Song song, Queue<Song> songs) {
        this.song = song;
        this.songs = songs;
    }

    public Song getNextSongToPlay() {
        return songs.peek();
    }

    public void queueSong(Song song) {
        this.songs.add(song);
    }
}
