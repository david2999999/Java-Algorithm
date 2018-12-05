public class ElementUniqueness {
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++) 
                if (data[j] == data[k])
                    return false;
        
        return true;
    }
}