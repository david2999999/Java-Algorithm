package PriorityQueue;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {
    private long id;
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient o) {
        if (this.getSeverity() > o.getSeverity()) return 1;
        else if (this.getSeverity() < o.getSeverity()) return -1;
        else return 0;
    }
}
