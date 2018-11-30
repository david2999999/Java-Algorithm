package Arrays;

public class Array {
    public static void main(String[] args) {
        int[] intArray = new int[7];
        intArray[0] = 20;
        intArray[1] = 20;
        intArray[2] = -15;
        intArray[3] = 10;
        intArray[4] = 20;
        intArray[5] = 20;
        intArray[6] = 20;

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
