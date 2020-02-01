public class Disjoint {
    public static boolean isDisjoint(int[] groupA, int[] groupB, int[] groupC) {
        for (int a: groupA) {
            for (int b: groupB) {
                if (a == b) {
                    for (int c: groupC) {
                        if (a == c)
                            return false;
                    }
                }
            }
        }

        return true;
    }
}