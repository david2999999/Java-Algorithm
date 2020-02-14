// write a function that returns true or false if a value
// is rotational symmetric

// example: "0891680" -> true
// to be symmetric, you should only rotate one side
public class RotationalSymmetric {
    @SuppressWarnings("serial")
    private static HashMap<Character, Character> rotationMap = new HashMap<Character, Character>() {{
        put('0', '0');
        put('1', '1');
        put('6', '9');
        put('8', '8');
        put('9', '6');
    }};

    public static boolean isRotationalSymmetric(String str) { // 0891680
        if (str == null || str.isEmpty()) {
            return false;
        }

        if (str.length() % 2 == 1) {
            int midIndex = str.length() / 2; // 7 / 2  = 3
            boolean isSymmetric = isRotationalSymmetric(str.charAt(midIndex));

            if (!isSymmetric) {
                return false;
            }
        }

        int lowIndex = 0;
        int highIndex = str.length() - 1;

        while (lowIndex < highIndex) {
            char low = str.charAt(lowIndex);
            char high = str.charAt(highIndex);

            if (!isRotationalSymmetric(low) || !isRotationalSymmetric(high)) {
                return false;
            }

            if (rotate(low) != high) {
                return false;
            }

            lowIndex++;
            highIndex--;
        }

        return true;
    }

    private static char rotate(char low) {
        if (!rotationMap.containsKey(low)) {
            throw new IllegalArgumentException();
        }

        return rotationMap.get(low);
    }

    private static boolean isRotationalSymmetric(char c) {
        return rotationMap.containsKey(c);
    }

    public static void main(String[] args) {
        String str1 = "0891680"; // -> 0891680 | 0861980 -> true
        String str2 = ""; // -> false
        String str3 = null; // -> false
        String str4 = "089680"; // 089680 | 086980 -> true
        String str5 = "189981"; // -> 189981 | 186681 -> false
        String str6 = "0897680"; // -> false

        System.out.println("IsRotationalSymmetric: " + str1 + " = " + isRotationalSymmetric(str1));
        System.out.println("IsRotationalSymmetric: " + str2 + " = " + isRotationalSymmetric(str2));
        System.out.println("IsRotationalSymmetric: " + str3 + " = " + isRotationalSymmetric(str3));
        System.out.println("IsRotationalSymmetric: " + str4 + " = " + isRotationalSymmetric(str4));
        System.out.println("IsRotationalSymmetric: " + str5 + " = " + isRotationalSymmetric(str5));
        System.out.println("IsRotationalSymmetric: " + str6 + " = " + isRotationalSymmetric(str6));
    }
}