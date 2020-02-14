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

        int index = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 10) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}
