public class ReverseWord {
    public void reverseWords(char[] charArray) {
        if (charArray == null || charArray.length <= 1) {
            return;
        }

        swap(charArray, 0, charArray.length - 1);

        int startIndex = 0;
        for (int endingIndex = 0; endingIndex <= charArray.length; i++) {
            if (endingIndex == charArray.length || charArray[endingIndex] == ' ') {
                swap(charArray, startIndex, endingIndex - 1);
                startIndex = endingIndex + 1;
            }
        }
    }

    private void swap(char[] charArray, int startingIndex, int endingIndex) {
        while (startingIndex < endingIndex) {
            char temp = charArray[startingIndex];
            charArray[startingIndex] = charArray[endingIndex];
            charArray[endingIndex] = temp;

            startingIndex++;
            endingIndex--;
        }
    }
}