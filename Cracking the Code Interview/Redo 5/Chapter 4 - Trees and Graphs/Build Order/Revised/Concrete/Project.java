public class Project implements DependencyProject {
    private int numberOfDependencies = 0;
    private String name;

    public Project(String name) {
        this.name = name;
    }

    @Override
    public void decrementDependencies() {
        numberOfDependencies--;
    }

    @Override
    public void incrementDependencies() {
        numberOfDependencies++;
    }

    @Override
    public boolean isReadyToBeBuilt() {
        return numberOfDependencies == 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
