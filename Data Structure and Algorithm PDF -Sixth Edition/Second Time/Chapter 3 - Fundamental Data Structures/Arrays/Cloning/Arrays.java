public class Arrays {
    public static int[][] deepClone(int[][] original) {
        int[][] backup = new int[original][];
        for (int k = 0; k < original.length; k++) {
            backup[k] = original[k].clone();
        }

        return backup;
    }
}