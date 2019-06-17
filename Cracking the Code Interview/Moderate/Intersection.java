package Moderate;

public class Intersection {
    private Point intersect(Point start1, Point end1, Point start2, Point end2) {
        if (start1.x > end2.x) swap(start1, end1);
        if (start2.x > end2.x) swap(start2, end2);
        if (start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        if (line1.slope == line2.slope) {
            if (line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1)) {
                return start2;
            }

            return null;
        }

        double x = (line2.yIntercept - line1.yIntercept) / (line1.slope - line2.slope);
        double y = line1.slope * x + line1.yIntercept;

        Point intersection = new Point(x, y);

        if (isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)) {
            return intersection;
        }

        return null;
    }


    private boolean isBetween(double start, double middle, double end) {
        if (start > end) {
            return end <= middle && middle <= start;
        } else {
            return start <= middle && middle <= end;
        }
    }

    private boolean isBetween(Point start, Point middle, Point end) {
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    private void swap(Point one, Point two) {
        double x = one.x;
        double y = one.y;

        one.setLocation(two.x, two.y);
        two.setLocation(x, y);
    }

    private class Line {
        public double slope, yIntercept;

        public Line(Point start, Point end) {
            double deltaY = end.y - start.y;
            double deltaX = end.x - start.x;
            slope = deltaY / deltaX;
            yIntercept = end.y - slope * end.x;
        }
    }

    private class Point {
        public double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setLocation(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
