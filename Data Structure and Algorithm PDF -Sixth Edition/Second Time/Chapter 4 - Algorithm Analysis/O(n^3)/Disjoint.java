public class Disjoint {
    public static boolean disjoint(int[] groupA, int[] groupB, int groupC) {
        for (int a: groupA) {
            for (int b: groupB) {
                for (int c: groupC) {
                    if ((a == b) && (b == c)) {
                        return false;
                    }
                }
            }
        }
    }
}