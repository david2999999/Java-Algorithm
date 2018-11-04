package CareerCup.MaxHalves;

public class MaxHalves {
    public static void main(String[] args) {
        generateMaxHalves(19967, 1000);
    }

    private static void generateMaxHalves(int num1, int num2) {
        String num1String = Integer.toString(num1);
        int minDifference = Integer.MAX_VALUE;

        int length = num1String.length();
        Result result = null;

        // Assuming splitting in half means at least 1 digit for one of the halves
        for (int i = 1; i < length; i++) {
            String firstHalf = num1String.substring(0, i);
            String secondHalf = num1String.substring(i);
            int sum = Integer.parseInt(firstHalf) + Integer.parseInt(secondHalf);

            if (sum <= num2) {
                if (minDifference > (num2 - sum)) {
                    minDifference = num2 - sum;
                    result = new Result(firstHalf, secondHalf, sum);
                }
            }
        }

        if (result != null) {
            System.out.println("Minimum pair (" + result.value1 + " , " + result.value2 + ") with a sum of " + result.sum);
        } else {
            System.out.println("No Minimum Pair found.");
        }
    }
}
