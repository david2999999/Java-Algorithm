public class MyPoint implements Point {
    private double x, y;
    public static Point ORIGIN = new MyPoint();
    
    private MyPoint() {
    }
    
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double amplitude() {
        return Math.atan(y/x);
    }
    public double distanceTo(Point point) {
        if (point.equals(this)) {
            return 0.0;
        } else if (!(point instanceof MyPoint)) {
            throw new IllegalArgumentException("use a MyPoint object");
        } else {
            MyPoint that = (MyPoint)point;
            double dx = that.x - this.x;
            double dy = that.y - this.y;
            return Math.sqrt(dx*dx + dy*dy);
        }
    }
    public boolean equals(Object object) {
        if (object==this) {
            return true;
        } else if (!(object instanceof MyPoint)) {
            return false;
    }
    
    MyPoint that = (MyPoint)object;
        return (that.x == this.x && that.y == this.y);
    }
    
    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }
    
    public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }
    
    public double xCoordinate() {
        return x;
    }
    
    public double yCoordinate() {
        return y;
    }
}