package Redo.Moderate.LineIntersection;

public class FindInterSection {
    private Point intersection(Point start1, Point end1, Point start2, Point end2) {
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isInBetween(start1, start2, end1)) {
                return start2;
            }
            return null;
        }

        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        double y = line1.slope * x + line1.yintercept;

        Point intersection = new Point(x, y);

        if (isInBetween(start1, intersection, end1) && isInBetween(start2, intersection, end2)) {
            return intersection;
        }

        return null;
    }

    private boolean isInBetween(Point start, Point mid, Point end) {
        return isInBetween(start.x, mid.x, end.x) && isInBetween(start.y, mid.y, end.y);
    }

    private boolean isInBetween(double start, double mid, double end) {
        if (start > end) {
            return (mid <= start && end <= mid);
        } else {
            return (start <= mid && mid <= end);
        }
    }

    private void swap(Point p1, Point p2) {
        double x = p1.x;
        double y = p1.y;

        p1.setPoint(p2.x, p2.y);
        p2.setPoint(x, y);
    }
}
