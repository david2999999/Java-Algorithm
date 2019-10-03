package BitManipulation;

// given a real number between 0 and 1 (eg .72), that is passed in as a double
// print the binary representation
// if the number can not be represented with 32 bits, print "ERROR"
public class BinaryToString {
    public String printBinary(double num) {
        // the number is not between 0 and 1
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder(); // using string builder to create the string
        binary.append("."); // add the first decimal point

        while (num > 0) {
            if (binary.length() >= 32) {    // exceeded the maximum bit number
                return "ERROR";
            }

            double r = num * 2; // basically shift the bits to the left

            if (r >= 1) {   // if after multiplying by 2 is greater than 1
                binary.append("1"); // add 1 to the string
                num = r - 1;
            } else {
                binary.append("0");
                num = r;
            }
        }

        return binary.toString();   // convert the binary to string
    }
}
