package ObjectOrientedDesign.Jukebox;

import java.util.Queue;

public class Playlist {
    private Song song;
    private Queue<Song> queue;

    public Playlist(Song song, Queue<Song> queue) {
        this.song = song;
        this.queue = queue;
    }

    public Song getNextSongToPlay() {
        return queue.peek();
    }

    public void queueUpSong(Song song) {
        queue.add(song);
    }
}
