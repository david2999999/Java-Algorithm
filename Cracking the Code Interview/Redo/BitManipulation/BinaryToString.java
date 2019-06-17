package Redo.BitManipulation;

public class BinaryToString {
    private String convert(double num) {
        if (num >= 1 || num <= 0) return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        while (num > 0) {
            if (binary.length() > 32) return "ERROR";

            double i = num * 2;
            if (i >= 1) {
                binary.append("1");
                num = i - 1;
            } else {
                binary.append("0");
                num = i;
            }
        }

        return binary.toString();
    }
}
