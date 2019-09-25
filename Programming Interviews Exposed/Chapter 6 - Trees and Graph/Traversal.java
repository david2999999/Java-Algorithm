public class Traversal {
    public void preorderTraversal( Node root ){
        if ( root == null ) return;

        root.printValue();
        preorderTraversal( root.getLeft() );
        preorderTraversal( root.getRight() );
    }
}
