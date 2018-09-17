package Redo.OOD.FileSystem;

import java.util.ArrayList;

public class Directory extends Entry{
    private ArrayList<Entry> contents;

    public Directory(Directory parent, String name) {
        super(parent, name);
        this.contents = new ArrayList<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry entry: contents) {
            size += entry.size();
        }

        return size;
    }

    public int numOfFiles() {
        int fileNumber = 0;
        for (Entry entry: contents) {
            if (entry instanceof Directory) {
                fileNumber++;
                fileNumber+= ((Directory) entry).numOfFiles();
            } else if (entry instanceof File) {
                fileNumber++;
            }
        }

        return fileNumber;
    }

    public boolean deleteEntry(Entry entry) {
        return this.contents.remove(entry);
    }

    public boolean addEntry(Entry entry) {
        return this.contents.add(entry);
    }

    public ArrayList<Entry> getContents() {
        return contents;
    }
}
