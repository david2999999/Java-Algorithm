package Redo;

public class SubString {
    private boolean isSubString(String str1, String str2) {
        int len = str1.length();

        if (len == str2.length() && len > 0) {
            String strDouble = str1 + str1;
            return isSubString(strDouble, str2);
        }

        return false;
    }
}
