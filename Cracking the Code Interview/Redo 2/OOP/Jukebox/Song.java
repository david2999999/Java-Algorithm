package OOP.Jukebox;

public class Song {
    private long id;
    private CD cd;
    private String title;
    private double length;

    public Song(long id, String title, double length) {
        this.id = id;
        this.title = title;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
