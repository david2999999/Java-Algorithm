package BitManipulation;

// write a function to determine the number of bits you would need to flip to convert
// integer A to B
// Example:
//          Input: 11101, 01111
//          Output: 2
public class ConversionOfBits {
    // to find the difference in bits of the two integer
    // we have to do the XOR operation and then count the number of 1s in the result

    public int bitSwapRequired(int a, int b) {
        int count = 0; // counter for the number of different bit in a and b

        // c = a XOR b
        // while c is not equal to 0
        // shift c to the right 1 place
        for (int c = a ^ b; c != 0; c = c >>> 1) {
            count += c & 1; // increment count when the least significant bit of c is equal to 1
        }

        return count;   // return the total number of different bits between the two numbers
    }

    // more optimized approach of using c = c & (c -1) to clear the least significant bit
    public int bitSwapRequiredOptimized(int a, int b) {
        int count = 0;  // counter for the number of different bit in a and b

        for (int c = a ^ b; c != 0; c = c & (c - 1)) { // c = c & (c -1) clears the least significant bit
            count++;
        }

        return count;  // return the total number of different bits between the two numbers
    }
}













