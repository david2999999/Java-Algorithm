package BitManipulation;

// given two 32 bit numbers, N and M, and two bit positions i and j.
// write a method to insert M into N such that M starts at bit j and ends at bit i

// input: N = 10000000000, M = 10011, i = 2, j = 6
// output: N = 10001001100
public class Insertion {
    // we have to first clear bits j through i in N
    // shift M so that it lines up with bits j through i
    // merge M and N

    public int updateBits(int n, int m, int i, int j) {
        // create a mask to clear bits i through j in N
        // for this example will use 8 bits

        // allOnes = 11111111
        int allOnes = ~0;   // create a sequence of all ones

        // if j = 4. then left will be 11100000
        int left = allOnes << (j + 1);  // shift the sequence to the left

        // 1's after position i, right = 00000011
        int right = ((1 << i) - 1);

        // mask = 11100011
        int mask = left | right;

        // clear bits j through i in n
        int n_cleared = n & mask;

        // shift m to the correct position to be inserted into n
        int m_shift = m << i;

        // merged m into n
        return n_cleared | m_shift;
    }
}














