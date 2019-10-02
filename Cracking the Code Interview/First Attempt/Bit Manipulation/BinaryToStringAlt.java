package BitManipulation;

public class BinaryToStringAlt {
    private String printBinaryString(double num) {
        if (num >= 1 || num < 0) return "ERROR";

        StringBuilder binary = new StringBuilder();
        binary.append(".");

        double frac = .5;


        while (num > 0) {
            if (binary.length() >= 32) return "ERROR";

            if (num > frac) {
                binary.append("1");
                num -= frac;
            } else {
                binary.append("0");
            }

            frac /= 2;
        }

        return binary.toString();

    }
}
