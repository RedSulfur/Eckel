package princeton.assignment3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public FastCollinearPoints(Point[] points) {

        if (points == null) throw new NullPointerException();

        List<Point> pointList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (pointList.contains(points[i])) throw new NullPointerException();
            pointList.add(points[i]);
        }

        if (pointList.contains(null)) throw new NullPointerException();

        List<LineSegment> listOfLineSegments = new ArrayList<>();
        int pointsCount = points.length;
        for (int p = 0; p < pointsCount; p++) {
            // Sort the points according to the slopes they makes with p.
            sort(points, points[p].slopeOrder());
            // Check if any 3 (or more) adjacent points in the sorted order have equal slopes with respect to p
            ArrayList<Point> collinearPoints = new ArrayList<Point>(pointsCount);
            for (int q = 0; q < pointsCount - 1; q++) {
                if (p == q) {
                    continue;
                }
                if (collinearPoints.isEmpty()) {
                    collinearPoints.add(points[q]);
                } else if (points[p].slopeTo(points[q - 1]) == points[p].slopeTo(points[q])) {
                    collinearPoints.add(points[q]);
                } else if (collinearPoints.size() > 2) {
                    // Draw collinear points.
                    collinearPoints.add(points[p]);
                    Collections.sort(collinearPoints);
                    // Display collinear points.
                    for (int i = 0; i < 3; i++) {
                        StdOut.print(collinearPoints.get(i));
                        StdOut.print(" -> ");
                    }
                    StdOut.println(Collections.max(collinearPoints));
                    Collections.min(collinearPoints).drawTo(Collections.max(collinearPoints));
                    break;
                } else {
                    collinearPoints.clear();
                    collinearPoints.add(points[q]);
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


    /***********************************************************************
     *  Bottom-Up merge sorting functions
     ***********************************************************************/

    // stably merge a[lo..m] with a[m+1..hi] using aux[lo..hi]
    private static void merge(Point[] a, Point[] aux, int lo, int m, int hi, Comparator<Point> comparator) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // merge back to a[]
        int i = lo, j = m + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > m) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(comparator, aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    // bottom-up mergesort
    private static void sort(Point[] a, Comparator<Point> comparator) {
        int N = a.length;
        Point[] aux = new Point[N];
        for (int n = 1; n < N; n = n + n) {
            for (int i = 0; i < N - n; i += n + n) {
                int lo = i;
                int m = i + n - 1;
                int hi = Math.min(i + n + n - 1, N - 1);
                merge(a, aux, lo, m, hi, comparator);
            }
        }
    }

    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/

    // is v < w ?
    private static boolean less(Comparator<Point> comparator, Point v, Point w) {
        return comparator.compare(v, w) < 0;
    }
}
