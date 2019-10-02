// A comparator for Employee instances.
public class EmployeeSequenceComparator implements Comparator<Employee> {
    public int compare( Employee e1, Employee e2 ){
        // Compare surname first.
        int ret = e1.surname.compareToIgnoreCase( e2.surname );
        // Ensure stability
        if ( ret == 0 ){
            ret = Integer.compare(e1.sequence, e2.sequence);
        }
        return ret;
    }
}