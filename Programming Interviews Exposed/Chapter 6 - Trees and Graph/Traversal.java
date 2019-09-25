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

    void preorderTraversalIteratively(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push( root );

        while( !stack.empty() ){
            Node curr = stack.pop();
            curr.printValue();

            Node n = curr.getRight();
            if ( n != null ) stack.push( n );

            n = curr.getLeft();
            if ( n != null ) stack.push( n );
        }
    }
}
