public class ReverseString {
    public static void reverse(char[] arrayOfChars) {
        if (arrayOfChars == null || arrayOfChars.length <= 1) {
            return;
        }

        int leftIndex = 0;
        int rightIndex = arrayOfChars.length - 1;

        while (leftIndex < rightIndex) {
            char temp = arrayOfChars[leftIndex];
            arrayOfChars[leftIndex] = arrayOfChars[rightIndex];
            arrayOfChars[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }
}