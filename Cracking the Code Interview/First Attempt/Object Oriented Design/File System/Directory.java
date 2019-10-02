package ObjectOrientedDesign.FileSystem;

import java.util.ArrayList;

public class Directory extends Entry {
    protected ArrayList<Entry> contents;

    public Directory(String n, Directory directory) {
        super(directory, n);
        this.contents = new ArrayList<>();
    }


    @Override
    public int size() {
        int size = 0;
        for (Entry e: contents) {
            size += contents.size();
        }

        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++;
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else if (e instanceof File) {
                count++;
            }
        }

        return count;
    }

    public boolean delete(Entry entry) {
        return this.contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        this.contents.add(entry);
    }

    public String getFullPath() {
        return "FullPath://";
    }

    public ArrayList<Entry> getContents() {
        return contents;
    }
}
