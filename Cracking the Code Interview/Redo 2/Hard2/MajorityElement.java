package Hard2;

// A majority element is an element that makes up more than half of the items in an array.
// Given a positive integers array, find the majority element, there is no majority element return -1
public class MajorityElement {
    // the slow method is just to iterate over the array and find the element
    public int findMajorityElement(int[] array) {
        for (int x: array) {
            if (validate(array, x)) {   // if the number x is the majority element
                return x;
            }
        }

        return -1;  // did not find the majority element
    }

    private boolean validate(int[] array, int majority) {
        int count = 0;

        for (int n: array) {
            if (n == majority) {    // if we found the element
                count++;            // increment the count
            }
        }

        return count > array.length / 2;    // checking if the count is more than half of the array size
    }

    // the quicker way of solving this problem is to verify the subarrays first, then verify the whole array
    public int findMajorityElementOptimized(int[] array) {
        int candidate = getCandidate(array);    // find the element that may be the majority element
        return validate2(array, candidate) ? candidate : -1; // validate the candidate to be the majority element
    }

    private boolean validate2(int[] array, int majority) {
        int count = 0;
        for (int n: array) {
            if (n == majority) {
                count++;
            }
        }

        return count > array.length / 2;    // check if the count is more than half of the array size
    }

    private int getCandidate(int[] array) {
        int majority = 0;
        int count = 0;

        for (int n: array) {
            if (count == 0) {   // there is no majority element in the previous set
                majority = n;
            }

            // this count variable is used to check the balance of the subsets
            // for example, if the subset is {1 , 2} and the 'majority' variable is 1
            // the number 2 will balance out of the subarray, then there is no majority element in this subset
            if (n == majority) {    // if the number is the majority element
                count++;
            } else {                // if the number is not the majority element
                count--;
            }
        }

        return majority;    // this may or may not be the majority element
    }

}




















