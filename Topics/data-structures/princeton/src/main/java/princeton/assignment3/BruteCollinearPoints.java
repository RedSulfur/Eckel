package princeton.assignment3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
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

        int pointsCount = points.length;

        for (int p = 0; p < pointsCount; p++) {
            for (int q = p + 1; q < pointsCount; q++) {
                double slopeToQ = points[p].slopeTo(points[q]);
                for (int r = q + 1; r < pointsCount; r++) {
                    double slopeToR = points[p].slopeTo(points[r]);
                    if (slopeToQ == slopeToR) {
                        for (int s = r + 1; s < pointsCount; s++) {
                            double slopeToS = points[p].slopeTo(points[s]);
                            if (slopeToQ == slopeToS) {
                                // Create the list of collinear points and sort them.
                                List<Point> collinearPoints = new ArrayList<Point>(4);
                                collinearPoints.add(points[p]);
                                collinearPoints.add(points[q]);
                                collinearPoints.add(points[r]);
                                collinearPoints.add(points[s]);
                                Collections.sort(collinearPoints);
                                // Display collinear points.
                                for (int i = 0; i < 3; i++) {
                                    StdOut.print(collinearPoints.get(i));
                                    StdOut.print(" -> ");
                                }
                                StdOut.println(Collections.max(collinearPoints));
                                Collections.min(collinearPoints).drawTo(Collections.max(collinearPoints));
                                listOfLineSegments
                                        .add(new LineSegment(Collections.min(collinearPoints),
                                                Collections.max(collinearPoints)));
                            }
                        }
                    }
                }
            }
        }
        lineSegments = listOfLineSegments.toArray(new LineSegment[listOfLineSegments.size()]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return this.getLineSegments();
    }

    private LineSegment[] getLineSegments() {
        return lineSegments;
    }
}
