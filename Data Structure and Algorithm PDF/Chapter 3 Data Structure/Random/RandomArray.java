import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        
        for (int i = 0; i < data.length; i++) 
            data[i] = rand.nextInt(100);
        
        int[] orig = Arrays.copyOf(data, data.length);
        
        System.out.println("arrays equal before sort: "+Arrays.equals(data, orig));
        Arrays.sort(data);
        System.out.println("arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("orig = " + Arrays.toString(orig));
        System.out.println("data = " + Arrays.toString(data));
    }
}