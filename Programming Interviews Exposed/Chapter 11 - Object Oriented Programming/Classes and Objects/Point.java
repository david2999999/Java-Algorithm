public class Point {
    private int x;
    private int y;

    public Point( int x, int y ){
        this.x = x;
        this.y = y;
    }

    public Point( Point other ){
        x = other.getX();
        y = other.getY();
    }

    public int getX(){ return x; }
    public int getY(){ return y; }
    public Point relativeTo( int dx, int dy ){
        return new Point( x + dx, y + dy );
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        b.append( '(' );
        b.append( x );
        b.append( ',' );
        b.append( y );
        b.append( ')' );
        return b.toString();
    }
}