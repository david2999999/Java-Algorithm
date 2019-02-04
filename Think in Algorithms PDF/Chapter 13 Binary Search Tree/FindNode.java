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