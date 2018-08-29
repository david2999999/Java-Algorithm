package StringAndArrays;

public class ReplacingSpaces {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("My John Smith    ", 13));
    }

    static String replaceSpaces(String str, int trueLength) {
        char[] strArr = str.toCharArray();
        int spaceCount = 0, index, i = 0;

        for (i = 0; i < trueLength; i++) {
            if (strArr[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;
        if (trueLength < strArr.length) strArr[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (strArr[i] == ' ') {
                strArr[index - 1] = '0';
                strArr[index - 2] = '2';
                strArr[index - 3] = '%';
                index -= 3;
            } else {
                strArr[index - 1] = strArr[i];
                index--;
            }
        }

        return new String(strArr);
    }
}
