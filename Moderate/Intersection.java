package Moderate;

public class Intersection {


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
