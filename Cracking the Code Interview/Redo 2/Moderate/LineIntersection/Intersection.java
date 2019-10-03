package Moderate.LineIntersection;

// given two straight line segments, represented as a start point and en end point
// compute the point of intersection
public class Intersection {
    // we have to create a Point class and also a Line class
    public Point intersection(Point start1, Point end1, Point start2, Point end2) {
        // if the starting point of the x coordinate
        // is greater than the x coordinate of the ending point
        // swap the two ends, this makes computation easier later
        if (start1.x > end1.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);

        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        // if the lines are parallel, they intercept only if they have the same y intercept
        // and start2 is on line 1
        if (line1.slope == line2.slope) {
            if (line1.yintercept == line2.yintercept && isBetween(start1, start2, end1)) {
                return start2;  // return any starting point
            }

            return null;    // they do not intercept
        }

        // y1 = m1 * x + b1
        // y2 = m2 * x + b2
        // m1 * x + b1 = m2 * x + b2
        // (m1 * x) - (m2 * x) = b2 - b1
        // x (m1 - m2) = b2 - b1
        // x = (b2 - b1) / (m1 - m2)
        double x = (line2.yintercept - line1.yintercept) / (line1.slope - line2.slope);
        double y = x * line1.slope + line1.yintercept;  // y = m * x + b
        Point intersection = new Point(x, y);

        // checking if the intersection is between the two end points of line1
        // and also the two end points of line2
        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;    // valid intersection
        }

        return null;    // did not find the intersection
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        // checking for both x and y coordinates
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private boolean isBetween(double start, double middle, double end) {
        // if start is greater than end
        if (start > end) {
            // assuming start >= middle >= end
            return end <= middle && middle <= start;
        } else {
            // assuming start <= middle <= end
            return start <= middle && middle <= end;
        }
    }

    // swap the location of the two points
    private void swap(Point one, Point two) {
        double x = one.x;
        double y = one.y;

        one.setLocation(two.x, two.y);
        two.setLocation(x, y);
    }
}
