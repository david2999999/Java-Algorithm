package Moderate.Intersection;

public class Line {
    public double slope, yintercept;

    public Line(Point start, Point end) {
        double deltaY = end.y - start.y;
        double deltaX = end.x - start.x;

        slope = deltaY / deltaX;
        yintercept = end.y - slope * end.x;
    }
}
