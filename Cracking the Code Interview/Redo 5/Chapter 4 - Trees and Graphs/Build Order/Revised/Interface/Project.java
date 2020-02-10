public interface Project extends Node {
    void decrementDependencies();
    void incrementDependencies();
    int getNumberOfDependencies();
}