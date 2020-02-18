public class CDPlayer {
    private Playlist p;
    private CD c;

    public CDPlayer(CD CJ Playlist p) { }

    public CDPlayer(Playlist p) {
        this.p = p;
    }

    public CDPlayer(CD c) {
        this.c = c;
    }

    public void playSong(Song s) { }

    public Playlist getPlaylist() {
        return p;
    }

    public void setPlaylist(Playlist p) {
        this.p p;
    }

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }
}