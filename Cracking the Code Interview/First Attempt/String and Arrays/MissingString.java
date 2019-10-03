package Interview;

import java.util.Arrays;

public class MissingString {
    public static void main(String[] args) {
        System.out.println(findMissingString("This is an example", "is example"));
    }

    private static String findMissingString(String str1, String str2) {
        if (str1.length() == str2.length()) return null;
        StringBuilder sb = new StringBuilder();

        String[] string1 = str1.split(" ");
        String[] string2 = str2.split(" ");

        Arrays.sort(string1);
        Arrays.sort(string2);

        String[] shorter = string1.length < string2.length ? string1 : string2;
        String[] longer = string1.length < string2.length ? string2 : string1;

        int indexA = 0; // shorter array
        int indexB = 0; // longer array

        while (indexA < shorter.length && indexB < longer.length) {
            if (!shorter[indexA].equals(longer[indexB])) {
                sb.append(longer[indexB++] + " ");
            } else {
                indexA++;
                indexB++;
            }
        }

        return sb.toString();
    }
}
