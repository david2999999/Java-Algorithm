class Tree
    {
    private Node root; // the only data field in Tree
    
    public Node find(int key) // find node with given key
        { // (assumes non-empty tree)
        Node current = root; // start at root
        while(current.iData != key) // while no match,
            {
            if(key < current.iData) // go left?
                current = current.leftChild;
            else
                current = current.rightChild; // or go right?
                
            if(current == null) // if no child,
                return null; // didn’t find it
            }
        return current; // found it
        }
    
    
    public void insert(int id, double dd)
        {
        Node newNode = new Node(); // make new node
        newNode.iData = id; // insert data
        newNode.dData = dd;
        
        if(root==null) // no node in root
            root = newNode;
        else // root occupied
            {
            Node current = root; // start at root
            Node parent;
            while(true) // (exits internally)
                {
                parent = current;
                if(id < current.iData) // go left?
                    {
                    current = current.leftChild;
                    if(current == null) // if end of the line,
                        { // insert on left
                        parent.leftChild = newNode;
                        return;
                        }
                    } // end if go left
                else // or go right?
                    {
                    current = current.rightChild;
                    if(current == null) // if end of the line
                        { // insert on right
                        parent.rightChild = newNode;
                        return;
                        }
                    } // end else go right
                } // end while
            } // end else not root
        } // end insert()
    public void delete(int id)
        {
        }
    // various other methods
    private void inOrder(node localRoot)
        {
        if(localRoot != null)
            {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + “ “);
            inOrder(localRoot.rightChild);
            }
        }
    } // end class Tree