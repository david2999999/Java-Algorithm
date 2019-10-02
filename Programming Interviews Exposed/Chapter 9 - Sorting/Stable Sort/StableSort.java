public class StableSort {
    public static void sortEmployeesStable( Employee[] employees ){
        for ( int i = 0; i < employees.length; ++i ){
            employees[i].sequence = i;
        }
        shakySort( employees, new EmployeeSequenceComparator() );
    }
}