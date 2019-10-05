public class URLIify {
    public void replaceSpace(char[] str, int trueLength) {
        int spaceCount = 0, index, i;

        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }

        index = trueLength + spaceCount * 2;

        for (i = trueLength; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
}