public class Merge {
    public int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr2;
        }

        if (arr2 == null || arr2.length == 0) {
            return arr1;
        }

        int[] mergedArray = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;
        int mergedIndex = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (index1 < arr1.length &&
                    (index2 >= arr2.length || arr1[index1] < arr2[index2])) {
                mergedArray[mergedIndex] = arr1[index1];
                index1++;
            } else {
                mergedArray[mergedIndex] = arr2[index2];
                index2++;
            }

            mergedIndex++;
        }

        return mergedArray;
    }
}