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

    Node findLowestCommonAncestor( Node root, int value1, int value2 ){
        while ( root != null ){
            int value = root.getValue();
            if ( value > value1 && value > value2 ){
                root = root.getLeft();
            } else if ( value < value1 && value < value2 ){
                root = root.getRight();
            } else {
                return root;
            }
        }
        return null; // only if empty tree
    }
}
