package Moderate.LineIntersection;

public class Line {
    public double slope, yintercept;    // the slop and y intercept of the line

    public Line(Point start, Point end) {   // the starting and end point of the line
        double deltaY = end.y - start.y;    // y2 - y1
        double deltaX = end.x - start.x;    // x2 - x1
        slope = deltaY / deltaX;            //(y2 - y1) / (x2 - x1)
        yintercept = end.y - slope * end.x;  // y = mx + b  -> b = y - mx
    }
}
