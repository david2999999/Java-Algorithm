public class Traversal {
    public void preorderTraversal( Node root ){
        if ( root == null ) return;

        root.printValue();
        preorderTraversal( root.getLeft() );
        preorderTraversal( root.getRight() );
    }

    void inorderTraversal( Node root ){
        if ( root == null ) return;

        inorderTraversal( root.getLeft() );
        root.printValue();
        inorderTraversal( root.getRight() );
    }

    void postorderTraversal( Node root ){
        if ( root == null ) return;

        postorderTraversal( root.getLeft() );
        postorderTraversal( root.getRight() );
        root.printValue();
    }
}
