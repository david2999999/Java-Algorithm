package CodeLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// HashMapList is a HashMap where a key maps to an arrayList
public class HashMapList<T, E> {
    private HashMap<T, ArrayList<E>> map = new HashMap<>();

    // insert item to the list at key
    public void put(T key, E item) {
        if (!map.containsKey(key)) {    // if the map does not contain this key
            map.put(key, new ArrayList<>());    // create a new Arraylist at that position in the map
        }

        map.get(key).add(item); // add the item to the arraylist
    }

    // insert a list of items at key
    public void put(T key, ArrayList<E> items) {
        map.put(key, items);
    }

    // get the list of items at key
    public ArrayList<E> get(T key) {
        return map.get(key);
    }

    // check if the HashMapList contains the key
    public boolean containsKey(T key) {
        return map.containsKey(key);
    }

    // checking if the arraylist at the key contains the value
    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false; // the list does not exist
        return list.contains(value);    // checking if the list contains the value
    }

    // generate a set of keys from map
    public Set<T> keySet() {
        return map.keySet();
    }

    // string representation of the map
    public String toString() {
        return map.toString();
    }
}
















