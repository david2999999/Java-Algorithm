public class University {
    private static class Department {
        final String name;
        Set<Professor> members;
       
        public Department(String name) {
            this.name = new String(name);
            this.members = new HashSet<Professor>();
        }
   
        public void add(Professor professor) {
            members.add(professor);
        }
    }
   
    private final String name;
    private Map<String, Department> departments;
   
    public University(String name) {
        this.name = new String(name);
        this.departments = new TreeMap<String, Department>();
    }
   
    public String getName() {
        return new String(name);
    }
    
    public void addDepartment(String name, Set<Professor> members) {
        Department dept = new Department(name);
        departments.put(name, dept);
        
        for (Professor prof : members) {
            dept.add(prof);
        }
    }
   
    public void add(Professor prof, String deptName) {
        Department dept = departments.get(deptName);
        if (dept == null) {
            throw new RuntimeException(deptName + " does not exist.");
        } else {
            dept.add(prof);
        }
    }
   
    public Set<String> departments() {
        return departments.keySet();
    }
}