package Hard.BabyNames;

import java.util.HashSet;
import java.util.Set;

public class NameSet {
    private HashSet<String> names = new HashSet<>();
    private int frequency = 0;
    private String rootName;

    public NameSet(String rootName, int frequency) {
        this.frequency = frequency;
        this.rootName = rootName;
    }

    public void copyNamesWithFrequency(Set<String> more, int freq) {
        names.addAll(more);
        frequency += freq;
    }

    public Set<String> getNames() {
        return names;
    }

    public String getRootName() {
        return rootName;
    }

    public int getFrequency() {
        return frequency;
    }

    public int size() {
        return names.size();
    }
}
