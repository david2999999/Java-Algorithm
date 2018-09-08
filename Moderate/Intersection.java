package Moderate;

public class Intersection {

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
