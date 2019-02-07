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
        
    public boolean delete(int key) // delete node with given key
        { // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        
        while(current.iData != key) // search for node
            {
            parent = current;
            if(key < current.iData) // go left?
                {
                isLeftChild = true;
                current = current.leftChild;
                }
            else // or go right?
                {
                isLeftChild = false;
                current = current.rightChild;
                }
            if(current == null) // end of the line,
                return false; // didn’t find it
            } // end while
        // if no children, simply delete it
        if(current.leftChild==null && current.rightChild==null)
            {
            if(current == root) // if root,
                root = null; // tree is empty
            else if(isLeftChild)
                parent.leftChild = null; // disconnect
            else // from parent
                parent.rightChild = null;
            }
        else if(current.rightChild==null)
            if(current == root)
                root = current.leftChild;
            else if(isLeftChild) // left child of parent
                parent.leftChild = current.leftChild;
            else // right child of parent
                parent.rightChild = current.leftChild;
            // if no left child, replace with right subtree
        else if(current.leftChild==null)
            if(current == root)
                root = current.rightChild;
            else if(isLeftChild) // left child of parent
                parent.leftChild = current.rightChild;
            else // right child of parent
                parent.rightChild = current.rightChild;
        else // two children, so replace with inorder successor
            {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);
            // connect parent of current to successor instead
            if(current == root)
                root = successor;
            else if(isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect successor to current’s left child
            successor.leftChild = current.leftChild;
            } // end else two children
            // (successor cannot have a left child)
        }
        

    private void inOrder(node localRoot)
        {
        if(localRoot != null)
            {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + “ “);
            inOrder(localRoot.rightChild);
            }
        }
        
    public Node minimum() // returns node with minimum key value
        {
        Node current, last;
        current = root; // start at root
        
        while(current != null) // until the bottom,
            {
            last = current; // remember node
            current = current.leftChild; // go to left child
            }
            
        return last;
        }
        
    public Node maximum() // returns node with minimum key value
        {
        Node current, last;
        current = root; // start at root
        
        while(current != null) // until the bottom,
            {
            last = current; // remember node
            current = current.rightChild; // go to right child
            }
            
        return last;
        }
    } // end class Tree