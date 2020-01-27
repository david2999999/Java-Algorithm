public class University {
    private static class Department {
        final String name;
        Set<Professor> members;

        public Department(String name) {
            this.name = new String(name);
            this.members = new HashSet<Professor>();
        }

        public void add(Professor professor) {
            this.members.add(professor);
        }
    }

    private final String name;
    private Map<String, Department> departments;

    public University(String name) {
        this.name = new String(name);
        this.departments = new TreeMap<String , Department>();
    }

    public String getName() {
        return name;
    }

    public void addDepartment(String name, Set<Professor> members) {
        Department department = new Department(name);
        this.departments.put(name, department);

        for (Professor professor: members) {
            department.add(professor);
        }
    }

    public void add(Professor professor, String departmentName) {
        Department department = departments.get(departmentName);

        if (department == null) {
            department = new Department(departmentName);
            departments.put(departmentName, department);
            department.add(professor);
        } else {
            department.add(professor);
        }
    }

    public Set<String> departments() {
        return departments.keySet();
    }
}






