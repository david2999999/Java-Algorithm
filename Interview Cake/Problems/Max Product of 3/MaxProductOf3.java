public class MaxProductOf3 {
    public int highesProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("Invalid numbers array.");
        }

        int highest = Math.max(nums[0], nums[1]);
        int lowest = Math.min(nums[0], nums[1]);

        int highestProductOf2 = highest * lowest;
        int lowestProductOf2 = highestProductOf2;

        int highestProductOf3 = highestProductOf2 * nums[3];

        for (int i = 2; i < nums.length; i++) {
            int current = nums[i];

            highestProductOf3 = Math.max(
                    Math.max(highestProductOf3, current * highestProductOf2),
                    current * lowestProductOf2);

            highestProductOf2 = Math.max(
                    Math.max(highestProductOf2, current * highest),
                    current * lowest);

            lowestProductOf2 = Math.min(
                    Math.min(lowestProductOf2, current * lowest),
                    current * highest);

            highest = Math.max(current, highest);
            lowest = Math.max(current, lowest);
        }

        return highestProductOf3;
    }
}