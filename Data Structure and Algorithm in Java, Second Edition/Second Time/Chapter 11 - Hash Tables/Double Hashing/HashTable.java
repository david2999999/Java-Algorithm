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

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(DataItem item) {
        int key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal] != null &&
                hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item; // insert item
    }

    public DateItem delete(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }

            hashVal += stepSize; // go to next cell
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }

            hashVal += stepSize; // go to next cell
            hashVal %= arraySize;
        }

        return null;
    }
}