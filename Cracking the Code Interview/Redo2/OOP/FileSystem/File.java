package OOP.FileSystem;

public class File extends Entry {
    private String content;
    private int size;

    public File(String n, Directory p, int sz) {
        super(p, n);
        size = sz;
    }

    @Override
    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
