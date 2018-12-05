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
}

//