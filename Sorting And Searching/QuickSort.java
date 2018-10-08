package Sorting;

public class QuickSort {
    public static void main(String a[]){

        QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private int array[];
    private int length;

    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) return;

        this.array = inputArr;
        this.length = inputArr.length;
        sort(0, length - 1);
    }

    private void sort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }

            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j) {
            sort(lowerIndex, j);
        }
        if (i < higherIndex) {
            sort(i, higherIndex);
        }
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



}
