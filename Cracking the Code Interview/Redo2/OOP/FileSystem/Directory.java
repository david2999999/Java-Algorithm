package OOP.FileSystem;

import java.util.ArrayList;

public class Directory extends Entry {

    protected ArrayList<Entry> contents;

    public Directory(String n, Directory p) {
        super(p, n);
        contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e: contents) {
            size += e.size();
        }

        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e: contents) {
            if (e instanceof Directory) {
                count++;
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else {
                count++;
            }
        }

        return count;
    }

    public boolean deleteEntry(Entry e) {
        return contents.remove(e);
    }

    public void addEntry(Entry e) {
        contents.add(e);
    }

    public ArrayList<Entry> getContents() {
        return contents;
    }
}








