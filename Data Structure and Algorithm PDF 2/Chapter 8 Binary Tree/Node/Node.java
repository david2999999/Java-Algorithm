class Node
    {
    int iData; // data used as key value
    double fData; // other data
    node leftChild; // this node’s left child
    node rightChild; // this node’s right child
    
    public void displayNode() // display ourself
        {
        System.out.print(‘{‘);
        System.out.print(iData);
        System.out.print(“, “);
        System.out.print(dData);
        System.out.print(“} “);
        }
    }