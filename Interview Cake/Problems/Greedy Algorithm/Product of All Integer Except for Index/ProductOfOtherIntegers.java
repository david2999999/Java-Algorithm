public class ProductOfOtherIntegers {
    public int[] findProductOfOthers(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Invalid number of elements inside array. Need 2 or more.");
        }

        int[] productOfNumsExceptForIndex = new int[arr.length];

        int currentProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            productOfNumsExceptForIndex[i] = currentProduct;
            currentProduct *= arr[i];
        }

        currentProduct = 1;
        for (int j = arr.length - 1; j >= 0; j--) {
            productOfNumsExceptForIndex[j] *= currentProduct;
            currentProduct *= arr[j];
        }

        return productOfNumsExceptForIndex;
    }
}