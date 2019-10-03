package Moderate;

// compute the number of trailing zeros in n factorial
// 5! = 5 * 4 * 3 * 2 * 1
public class FactorialZero {
    // to know the number of trailing zeros, we need to know how many multiples of 10 is in the total
    // the number 10 can be factored into 5 and 2
    // since there are more factors of 2 than the factors of 5
    // we can just get the total numbers of factors of 5

    public int countFactZeros(int num) {
        int count = 0;  // total factors of 5

        for (int i = 2; i <= num; i++) {
            count += factorsOf5(i); // getting the number of factors of 5
        }

        return count;
    }

    // 5 -> has 1 factor of 5
    // 25 -> has 2 factors of 5
    private int factorsOf5(int i) {
        int count = 0;

        while (i % 5 == 0) {    // while there is still more factors of 5
            count++;
            i /= 5;
        }

        return count;
    }

    // there is a more optimized way of calculating the total number of factors of 5
    public int countFactZeroOptimized(int num) {
        int count = 0;
        if (num < 0) {  // invalid number
            return -1;
        }

        // each multiple of 5 gets a single count of 5
        // each multiple of 25 gets 2 counts of 5, since 5 * 5 = 25
        // each multiple of 125 gets 3 counts of 5, since 5 * 5 * 5 = 125
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }

        return count;   // total number of factors of 5
    }

}






