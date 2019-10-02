public abstract class Shape {
    protected Point center;

    protected Shape( Point center ){
        this.center = center;
    }

    public Point getCenter(){
        return center; // because Point is immutable
    }

    public abstract Rectangle getBounds();
    public abstract void draw( Graphics g );
}