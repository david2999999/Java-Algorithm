package Moderate;

public class BIsectSquare {
    private class Square {
        private int left;
        private int right;
        private int top;
        private int bottom;
        private int size;

        public Point middle() {
            return new Point((left + right) / 2, (top + bottom) / 2);
        }

        public Point extend(Point mid1, Point mid2, double size) {
            double xdir = mid1.x < mid2.x ? -1 : 1;
            double ydir = mid1.y < mid2.y ? -1 : 1;

            if (mid1.x == mid2.x) return new Point(mid1.x, mid1.y + ydir * size / 2);

            double slope = (mid1.y - mid2.y) / (mid1.x - mid2.x);
            double y1 = 0;
            double x1 = 0;

            if (Math.abs(slope) == 1) {
                x1 = mid1.x + xdir * size / 2;
                y1 = mid1.y + ydir * size / 2;
            } else if (Math.abs(slope) > 1) {
                x1 = mid1.x + xdir * size / 2;
                y1 = slope * (x1 - mid1.x) + mid1.y;
            } else {
                y1 = mid1.y + ydir * size / 2;
                x1 = (y1 - mid1.y) / slope + mid1.x;
            }

            return new Point(x1, y1);
        }

        public Line cut(Square other) {
            Point p1 = extend(this.middle(), other.middle(), this.size);
            Point p2 = extend(this.middle(), other.middle(), -1 * this.size);
            Point p3 = extend(other.middle(), this.middle(), other.size);
            Point p4 = extend(other.middle(), this.middle(), -1 * other.size);

            Point start = p1;
            Point end = p2;
            Point[] points = {p2, p3, p4};

            for (int i = 0; i < points.length; i++) {
                if (start.x > points[i].x || (start.x == points[i].x && start.y > points[i].y)) {
                    start = points[i];
                } else if (points[i].x > end.x || (end.x == points[i].x && end.y < points[i].y)){
                    end = points[i];
                }
            }

            return new Line(start, end);
        }
    }

    private class Line {
        private Point start;
        private Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    }

    private class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
