package princeton.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("Duplicates")
public class BruteCollinearPoints {

    private static final  int MAX_SCALE_VALUE = 32768;
    /**
     * Constant holding radius for points drawing
     */
    private static final double POINT_RADIUS = 0.003;
    /**
     * Constant holding radius for lines drawing
     */
    private static final double LINE_RADIUS = 0.005;

    private LineSegment[] lineSegments;

    public BruteCollinearPoints(Point[] points)  {

        if (points == null) throw new NullPointerException();

        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if(pointList.contains(points[i])) throw new NullPointerException();
            pointList.add(points[i]);
        }

        if(pointList.contains(null)) throw new NullPointerException();

        List<LineSegment> listOfLineSegments = new ArrayList<>();

        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point q = points[j];
                double slopePQ = p.slopeTo(q);
                for (int k = j + 1; k < points.length; k++) {
                    Point r = points[k];
                    double slopePR = p.slopeTo(r);
                    if (slopePQ != slopePR) continue;
                    for (int l = k + 1; l < points.length; l++) {
                        Point s = points[l];
                        double slopePS = p.slopeTo(s);
                        if (slopePQ == slopePR && slopePQ == slopePS) {
                            addLineSegment(listOfLineSegments, p, q, r, s);
                            p.drawTo(s);
                        }
                    }
                }
            }
        }
        lineSegments = listOfLineSegments.toArray(new LineSegment[listOfLineSegments.size()]);
    }

    private void addLineSegment(List<LineSegment> segments, Point... points) {
        segments.add(new LineSegment(points[0], points[1]));
        segments.add(new LineSegment(points[1], points[2]));
        segments.add(new LineSegment(points[2], points[3]));
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments;
    }
}
