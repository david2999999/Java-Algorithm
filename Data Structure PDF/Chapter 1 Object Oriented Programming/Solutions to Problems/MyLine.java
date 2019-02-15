public class MyLine implements Line {
    private double m, b; // slope, intercept
    public static Line X_AXIS = new MyLine();
    
    private MyLine() {
    }
    
    public MyLine (double m, double b) {
        this.m = m;
        this.b = b;
    }
    
    public boolean contains(Point point) {
        double x = point.xCoordinate();
        double y = point.yCoordinate();
        return y == m*x + b;
    }
    
    public boolean equals(Object object) {
        if (object==this) {
            return true;
        } else if (!(object instanceof MyLine)) {
            return false;
        }
        
        MyLine that = (MyLine)object;
        return (that.m == this.m && that.b == this.b);
    }
    public boolean isHorizontal() {
        return m == 0.0;
    }
    
    public boolean isVertical() {
        return m == Double.POSITIVE_INFINITY || m==Double.NEGATIVE_INFINITY;
    }
    
    public double slope() {
        return m;
    }
    
    public String toString() {
        return String.format("y = %.2fx + %.2f", m, b);
    }
    
    public double xIntercept() {
        if (isHorizontal()) {
            throw new RuntimeException("this line is horizontal");
        }
        
        return -b/m;
    }
    
    public double yIntercept() {
        if (isVertical()) {
            throw new RuntimeException("this line is vertical");
        }
        return b;
    }
}