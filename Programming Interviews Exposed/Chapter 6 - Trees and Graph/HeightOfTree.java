public static int treeHeight( Node n ){
    if ( n == null ) return 0;
    return 1 + Math.max( treeHeight( n.getLeft() ), treeHeight( n.getRight() ) );
}