public class Merge {
    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0, indexResult = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                result[indexResult++] = arr1[index1++];
            } else {
                result[indexResult++] = arr2[index2++];
            }
        }

        while (index1 < arr1.length) {
            result[indexResult++] = arr1[index1++];
        }

        while (index2 < arr2.length) {
            result[indexResult++] = arr2[index2++];
        }
    }
}