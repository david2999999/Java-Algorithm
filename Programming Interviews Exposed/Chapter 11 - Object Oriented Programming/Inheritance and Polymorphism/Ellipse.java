public class Ellipse extends Shape {
    private int a;
    private int b;

    public Ellipse( Point center, int a, int b ){
        super( center );
        this.a = a;
        this.b = b;
    }

    public Rectangle getBounds(){
        return new Rectangle( center, a * 2, b * 2 );
    }

    public int getHorizontalAxis(){ return a; }
    public int getVerticalAxis(){ return b; }
    public void draw( Graphics g ){
         // code to paint ellipse
    }
}