import java.util.Comparator;

// A comparator for Employee instances.
public class EmployeeNameComparator implements Comparator<Employee> {
    public int compare( Employee e1, Employee e2 ){
        // Compare surnames
        int ret = e1.surname.compareToIgnoreCase( e2.surname );
        if ( ret == 0 ){ // Compare givennames if surnames are the same
            ret = e1.givenname.compareToIgnoreCase( e2.givenname );
        }
        return ret;
    }
}

public static void sortEmployees( Employee[] employees ){
    Arrays.sort( employees, new EmployeeNameComparator() );
}