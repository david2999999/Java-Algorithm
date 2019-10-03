package Moderate.Intersection;

public class Intersection {
    public Point intersection(Point start1, Point end1, Point start2, Point end2) {
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
                return start2;
            }

            return null;
        }

        double x = (line2.yintercept - line1.yintercept) /  (line1.slope - line2.slope);
        double y = x * line1.slope + line1.yintercept;
        Point intersection = new Point(x, y);

        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }

        return null;
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    private void swap(Point one, Point two) {
        double x = one.x;
        double y = one.y;

        one.setLocation(two.x, two.y);
        two.setLocation(x, y);
    }
}
