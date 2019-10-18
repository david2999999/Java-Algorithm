public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j=0; j<arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("”);
    }

    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }

    public void insert(DataItem item) {
        int key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item; // insert item
    }
}