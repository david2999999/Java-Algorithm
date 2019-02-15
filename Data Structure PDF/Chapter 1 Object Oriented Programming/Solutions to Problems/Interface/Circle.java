public interface Circle {
    public double area();
    public Point center();
    public double circumference();
    public boolean contains(Point point);
    public boolean equals(Object object);
    public double radius();
    public String toString();
}