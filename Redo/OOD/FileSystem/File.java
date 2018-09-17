package Redo.OOD.FileSystem;

public class File extends Entry {
    public File(Directory parent, String name) {
        super(parent, name);
    }

    @Override
    public int size() {
        return 0;
    }
}
