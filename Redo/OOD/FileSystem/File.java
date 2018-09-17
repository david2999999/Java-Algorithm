package Redo.OOD.FileSystem;

public class File extends Entry {
    private int size;
    private String content;

    public File(Directory parent, String name, int size) {
        super(parent, name);
        this.size = size;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int getSize() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
