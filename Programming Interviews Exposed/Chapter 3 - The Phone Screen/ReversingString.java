public static String reverse( String in ) {
    int len = in.length();
    StringBuilder out = new StringBuilder( len );

    for ( int i = len - 1; i >= 0; --i ) {
        out.append( in.charAt( i ) );
    }
    return out.toString();
}