public class ElementUniqueness {
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j = 0; j < n - 1; j++)
            for (int k = j + 1; k < n; k++) 
                if (data[j] == data[k])
                    return false;
        
        return true;
    }
    
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);
        Arrays.sort(temp);
        
        for (int j = 0; j < n - 1; j++) {
            if (temp[j] == temp[j + 1])
                return false;
        }
        
        return true;
    }
}