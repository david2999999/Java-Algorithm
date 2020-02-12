public class BottomUpMergeSort {
    public <E> void sort(K[] originalElements, Comparator<K> comp) {
        int length = originalElements.length;

        K[] source = originalElements;
        K[] destination = (K[]) new Object[length];


        for (int increments = 1; increments < length; increments *= 2) {
            for (int startIndex = 0; startIndex < length; startIndex += increments * 2) {
                merge(source, destination, comp, startIndex, increments);
            }

            swap(source, destination);
        }

        if (originalElements != source) {
            System.arraycopy(source, 0, originalElements, 0, length);
        }
    }

    public <E> void swap(K[] source, K[] destination) {
        K[] temp = source;
        source = destination;
        destination = temp;
    }
}