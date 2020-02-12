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

    public <K> void merge(K[] source, K[] destination, Comparator<K> comp,
                          int startIndex, int increments) {
        int end1 = Math.min(startIndex + increments, source.length);
        int end2 = Math.min(startIndex + 2 * increments, source.length);

        int index1 = startIndex;
        int index2 = startIndex + increments;

        int accumulatorIndex = startIndex;

        while (index1 < end1 && index2 < end2) {
            if (comp.compare(source[index1], source[index2]) < 0) {
                destination[accumulatorIndex++] = source[index1++];
            } else {
                destination[accumulatorIndex++] = source[index2++];
            }
        }

        if (index1 < end1) {
            System.arraycopy(source, index1, destination, accumulatorIndex, end1 - index1);
        } else if (index2 < end2) {
            System.arraycopy(source, index2, destination, accumulatorIndex, end2 - index2);
        }
    }

    public <E> void swap(K[] source, K[] destination) {
        K[] temp = source;
        source = destination;
        destination = temp;
    }
}