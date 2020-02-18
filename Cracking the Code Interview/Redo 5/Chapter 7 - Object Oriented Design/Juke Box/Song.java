public class Song {
    private long id;
    private CD cd;
    private String title;
    private long length;

    public Song(long id, CD cd, String title, long length) {
        this.id = id;
        this.cd = cd;
        this.title = title;
        this.length = length;
    }
}