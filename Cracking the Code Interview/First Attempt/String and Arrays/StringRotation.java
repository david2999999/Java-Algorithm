package StringAndArrays;

public class StringRotation {
    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    private static boolean isRotation(String s1, String  s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.toLowerCase().contains(s2.toLowerCase());
    }
}
