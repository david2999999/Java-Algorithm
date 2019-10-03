package BitManipulation.MaxSequence;

// Given an integer and you can flip exactly one bit from 0 to a 1
// write a function to find the length of the longest sequence of 1s you can create
public class MaximumSequenceOfBitsOptimized {
    // In this optimized approach, we will count the number of 1s as we scan through the bits
    // if there is a 0, we will check the next bit
    // if the next bit is also a zero, reset the previous value
    // if the next bit is a 1, we can keep the previous value

    public int flipBit(int a) {
        if (~a == 0) return Integer.BYTES * 8;  // the integer contains all 1s

        int currentLength = 0;  // tracking the current length
        int previousLength = 0; // tracking the previous length
        int maxLength = 1;  // keeps track of the maximum length, we can always have a length of 1
        while (a != 0) {
            if ( (a & 1) == 1) {    // current bit is 1
                currentLength++;    // increment the current length
            } else if ((a & 1) == 0) {  // current bit is 0
                // checks if the next bit is also 0
                // if the next bit is also zero, reset the previous length to 0, we can not connect
                // the two lengths because we can only flip 1 bit
                // else set it to the current length
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;  // reset the current length, since we found a 0
            }

            // compare to find the longest length
            // the + 1 is for the flip bit from 0 to 1
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);

            a >>>= 1;   // shift the number to the right
        }

        return maxLength;   // return the maximum sequence
    }
}













