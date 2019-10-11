public class ShellSort {
    private int[] array;
    private int numberOfElements;

    public ShellSort(int max) {
        array = new int[max];
        numberOfElements = 0;
    }

    public void sort() {
        int inner, outer, temp;

        int h = 1;
        while (h <= numberOfElements / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < numberOfElements; outer++) {
                temp = array[outer];
                inner = outer;

                while (inner > h - 1 && array[inner - h] >= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }

                array[inner] = temp;
            }

            h = (h - 1) / 3;
        }
    }
}