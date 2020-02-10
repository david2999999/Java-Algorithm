public interface Project {
    void decrementDependencies();
    void incrementDependencies();
    int getNumberOfDependencies();
}