package princeton.assignment3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BruteCollinearPoints {

    private Point[] points;
    private LineSegment[] lineSegments;

    {
        List<Point> pointList = Arrays.stream(points).filter(slopes -> checkSlopes())
                .collect(Collectors.toList());
    }

    public BruteCollinearPoints(Point[] points)  {



        for (int i = 0; i < points.length; i++) {
            double slope1 = points[i].slopeTo(points[i + 1]);
            double slope2 = points[i].slopeTo(points[i + 2]);
            double slope3 = points[i].slopeTo(points[i + 3]);
            double slope4 = points[i].slopeTo(points[i + 4]);

            double slope = getSlope(points[i], points[i + 1]);

            if(slope1 == slope2 &&
                    slope1 == slope3 &&
                    slope1 == slope4) {
                LineSegment lineSegment1 = new LineSegment(points[i], points[i + 1]);
                LineSegment lineSegment2 = new LineSegment(points[i + 1], points[i + 2]);
                LineSegment lineSegment3 = new LineSegment(points[i + 2], points[i + 3]);
                LineSegment lineSegment4 = new LineSegment(points[i + 3], points[i + 4]);
            }
        }
    }

    private boolean checkSlopes(double... slopes) {
        return slopes[0] == slopes[1]
                && slopes[0] == slopes[2]
                && slopes[0] == slopes[3];
    }

    public double getSlope(Point p1, Point p2) {
        return 0;
    }
//    public           int numberOfSegments() // the number of line segments
//    public LineSegment[] segments() {
//    }
}
