package Moderate.BestLine;

public class Line {
    public static double epsilon = .0001;
    public double slope, intercept;
    public boolean infiniteSlope = false;

    public Line(GraphPoint p, GraphPoint q) {
        if (Math.abs(p.x - q.x) > epsilon) {
            slope = (p.y - q.y) / (p.x - q.x);
            intercept = p.y - slope * p.x;
        } else {
            infiniteSlope = true;
            intercept = p.x;
        }
    }

    public static double floorToNearestEpsilon(double d) {
        int r = (int)(d / epsilon);
        return ((double)r) * epsilon;
    }

    public boolean isEquivalent(double a, double b) {
        return ((Math.abs(a - b)) < epsilon);
    }

    public boolean isEquivalent(Object o) {
        Line l = (Line) o;
        if (isEquivalent(l.slope, slope) && isEquivalent(l.intercept, intercept) && (infiniteSlope == l.infiniteSlope)) {
            return true;
        }

        return false;
    }
}
