package ObjectOrientedDesign.FileSystem;

public class File extends Entry {

    private String content;
    private int size;

    public File(String n, Directory p, int sz){
        super(p, n);
        this.size = sz;
    }

    @Override
    public int size() {
        return this.size;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
