public class CD {
    private long id;
    private ArrayList<String> artists;
    private ArrayList<Song> songs;

    public CD (long id, ArrayList<String> artists, ArrayList<Song> songs) {
        this.id = id;
        this.artists = artists;
        this.songs = songs;
    }
}
