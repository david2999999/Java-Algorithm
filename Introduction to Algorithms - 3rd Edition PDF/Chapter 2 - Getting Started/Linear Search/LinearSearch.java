public class LinearSearch {
    public E int search(E[] arr, E target) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }

        return null;
    }
}