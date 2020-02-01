public class UniqueElements {
    public static boolean isUnique(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);

        for (int i = 0; i < n - 1; i++) {
            if (data[i] == data[i + 1]) {
                return false;
            }
        }

        return true;
    }
}