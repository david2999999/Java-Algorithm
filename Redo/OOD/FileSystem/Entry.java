package Redo.OOD.FileSystem;

public abstract class Entry {
    protected Directory parent;
    protected long created;
    protected long lastUpdated;
    protected long lastAccessed;
    protected String name;

    public Entry(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        this.created = System.currentTimeMillis();
        this.lastUpdated = System.currentTimeMillis();
        this.lastAccessed = System.currentTimeMillis();
    }

    public boolean delete() {
        if (this.parent == null) return false;
        return this.parent.deleteEntry(this);
    }

    public abstract int size();

    public String getFullPath() {
        if (this.parent == null) return name;
        return this.parent.getFullPath() + "/" + name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public long getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
