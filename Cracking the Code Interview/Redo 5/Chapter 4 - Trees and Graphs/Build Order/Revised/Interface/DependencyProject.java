public interface DependencyProject {
    String getName();
    void setName(String name);
    void decrementDependencies();
    void incrementDependencies();
    boolean isReadyToBeBuilt();
}