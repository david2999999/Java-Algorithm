public class HashTable {
    private SortedList[] array;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        array = new SortedList[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = new SortedList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link link) {
        int key = link.getKey();
        int hashVal = hashFunc(key);
        array[hashVal].insert(link);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        array[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link link = array[hashVal];
        return link;
    }
}