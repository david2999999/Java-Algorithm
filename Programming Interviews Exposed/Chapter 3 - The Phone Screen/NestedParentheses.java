public static boolean checkNesting( String s ) {
    int count = 0;
    for ( int i = 0; i < s.length(); ++i ) {
        char ch = s.charAt( i );
        if ( ch == '(' ) {
            ++count;
        } else if ( ch == ')' ) {
            --count;
            if ( count < 0 ) return false;
        }
    }
    return count == 0;
}