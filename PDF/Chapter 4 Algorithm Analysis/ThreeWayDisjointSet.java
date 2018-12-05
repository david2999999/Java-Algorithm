public class ThreeWayDisjointSet {
    //This simple algorithm loops through each possible triple of values from the
    // three sets to see if those values are equivalent. If each of the original sets has size
    // n, then the worst-case running time of this method is O(n^3).
    public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
        for (int a: groupA) 
            for (int b : groupB)
                for (int c: groupC)
                    if ((a == b) && (b == c))
                        return false;
        return true;
    }
    
    //To account for the overall running time, we examine the time spent executing
    // each line of code. The management of the for loop over A requires O(n) time. The
    // management of the for loop over B accounts for a total of O(n2) time, since that
    // loop is executed n different times. The test a == b is evaluated O(n2) times. The
    // rest of the time spent depends upon how many matching (a,b) pairs exist. As we
    // have noted, there are at most n such pairs; therefore, the management of the loop
    // over C and the commands within the body of that loop use at most O(n2) time. By
    // our standard application of Proposition 4.8, the total time spent is O(n2).
    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        for (int a: groupA)
            for (int b: groupB)
                if (a == b) 
                    for (int c: groupC)
                        if (a == c)
                            return false;
        return true;
    }
}

