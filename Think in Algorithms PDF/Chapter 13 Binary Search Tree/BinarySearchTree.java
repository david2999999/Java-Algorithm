public class BinarySearchTree {
    
    public boolean containsValue(Object target) {
        return containsValueHelper(root, target);
    }
    
    private boolean containsValueHelper(Node node, Object target) {
        if (node == null) {
            return false;
        }
        
        if (equals(target, node.value)) {
            return true;
        }
        
        if (containsValueHelper(node.left, target)) {
            return true;
        }
        
        if (containsValueHelper(node.right, target)) {
            return true;
        }
        
        return false;
    }
    
    private Node findNode(Object target) {
        // some implementations can handle null as a key, but not this one
        if (target == null) {
            throw new IllegalArgumentException();
        }
        
        // something to make the compiler happy
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) target;
        // the actual search
        
        Node node = root;
        while (node != null) {
            int cmp = k.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node;
        }
        
        return null;
    }
    
    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (root == null) {
            root = new Node(key, value);
            size++;
            return null;
        }
        
        return putHelper(root, key, value);
    }
    
    private V putHelper(Node node, K key, V value) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        int cmp = k.compareTo(node.key);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.left, key, value);
            }
        }
        
        if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                size++;
                return null;
            } else {
                return putHelper(node.right, key, value);
            }
        }
        
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }
}