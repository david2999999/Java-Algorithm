public class BinarySearch {
    public static boolean search(int target, int[] nums) {
        int floorIndex = -1;
        int ceilingIndex = nums.length;

        while (floorIndex + 1 < ceilingIndex) {
            int distance = ceilingIndex - floorIndex;
            int halfDistance = distance / 2;
            int guessIndex = floorIndex + halfDistance;

            int guessValue = nums[guessIndex];

            if (guessValue == target) {
                return true;
            } else if (guessValue > target) {
                ceilingIndex = guessIndex;
            } else {
                floorIndex = guessIndex;
            }
        }

        return false;
    }
}

// 1) Start with the middle number: is it bigger or smaller
// than our target number? Since the array is sorted, this
// tells us if the target would be in the left half or the right half of our array.

// 2) We've effectively divided the problem in half. We can
// "rule out" the whole half of the array that we know doesn't
// contain the target number.

// 3) Repeat the same approach (of starting in the middle)
// on the new half-size problem. Then do it again and again,
// until we either find the number or "rule out" the whole set.