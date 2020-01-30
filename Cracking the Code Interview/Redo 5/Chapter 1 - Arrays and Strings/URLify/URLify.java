public class URLify {
    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = countSpaces(str, trueLength);

        int index = trueLength + spaceCount * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '3';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public int countSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        return spaceCount;
    }
}