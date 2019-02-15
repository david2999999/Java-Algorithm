public class MyCircle implements Circle {
    private Point c; // center
    private double r; // radius
    
    public MyCircle() {
    }
    
    public MyCircle(Point c, double r) {
        this.c = c;
        this.r = r;
    }
    
    public double area() {
        return Math.PI*r*r;
    }
    
    public Point center() {
        return c;
    }
    
    public double circumference() {
        return 2*Math.PI*r;
    }
    
    public boolean contains(Point point) {
        double x = point.xCoordinate();
        double y = point.yCoordinate();
        return x*x + y*y < r*r;
    }
    public boolean equals(Object object) {
        if (object==this) {
            return true;
        } else if (!(object instanceof MyCircle)) {
            return false;
        }
        
        MyCircle that = (MyCircle)object;
            return (that.c == this.c && that.r == this.r);
        }
        
        public double radius() {
            return r;
        }
        
    public String toString() {
        return String.format("[Center: %.2fx; Radius: %.2f]", c, r);
    }
}