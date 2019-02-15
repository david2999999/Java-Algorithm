public interface Line {
    public boolean contains(Point point);
    public boolean equals(Object object);
    public boolean isHorizontal();
    public boolean isVertical();
    public double slope();
    public String toString();
    public double xIntercept();
    public double yIntercept();
}