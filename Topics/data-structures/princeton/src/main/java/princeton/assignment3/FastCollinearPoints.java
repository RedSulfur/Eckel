package princeton.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class FastCollinearPoints {

    private static final int MAX_SCALE_VALUE = 32768;
    /**
     * Constant holding radius for points drawing
     */
    private static final double POINT_RADIUS = 0.003;
    /**
     * Constant holding radius for lines drawing
     */
    private static final double LINE_RADIUS = 0.005;

    private LineSegment[] lineSegments;

    public FastCollinearPoints(Point[] points)  {

        if (points == null) throw new NullPointerException();

        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (pointList.contains(points[i])) throw new NullPointerException();
            pointList.add(points[i]);
        }

        if (pointList.contains(null)) throw new NullPointerException();

        List<LineSegment> listOfLineSegments = new ArrayList<>();
        LinkedList<Point> pointLinkedList = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];

            Point[] adjacentPoints = Arrays.copyOfRange(points, i + 1, points.length);
            Arrays.sort(adjacentPoints, p.slopeOrder());

            for (int j = 0; j < adjacentPoints.length - 2; j++) {
                double slopePQ = p.slopeTo(adjacentPoints[j]);
                double slopePR = p.slopeTo(adjacentPoints[j + 1]);
                double slopePS = p.slopeTo(adjacentPoints[j + 2]);

                if (slopePQ == slopePR && slopePQ == slopePS) {
                    listOfLineSegments.add(new LineSegment(p, adjacentPoints[j]));
                    listOfLineSegments.add(new LineSegment(adjacentPoints[j], adjacentPoints[j + 1]));
                    listOfLineSegments.add(new LineSegment(adjacentPoints[j + 1], adjacentPoints[j + 2]));
                    pointLinkedList.addLast(adjacentPoints[j + 2]);
                    j += 3;

                    while (j > 0 && j < adjacentPoints.length
                            && slopePQ == p.slopeTo(adjacentPoints[j])) {
                        pointLinkedList.addLast(adjacentPoints[j++]);
                    }
                    p.drawTo(pointLinkedList.pollLast());
                }
            }
        }
        lineSegments = listOfLineSegments.toArray(new LineSegment[listOfLineSegments.size()]);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public LineSegment[] segments() {
        return lineSegments;
    }
}
