package princeton.assignment3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;

public class BruteCollinearPoints {

    private final static int MAX_SCALE_VALUE = 32768;
    /**
     * Constant holding radius for points drawing
     */
    private static final double POINT_RADIUS = 0.02;
    /**
     * Constant holding radius for lines drawing
     */
    private static final double LINE_RADIUS = 0.005;

    private static Point[] points;
    private static LineSegment[] lineSegments;

    public static void main(String[] args) throws IOException {
        StdDraw.setXscale(0, MAX_SCALE_VALUE);
        StdDraw.setYscale(0, MAX_SCALE_VALUE);
        StdDraw.setPenRadius(POINT_RADIUS);
        In input = new In(args[0]);
        int n = input.readInt();
        Point[] points = new Point[n];
        for (int i = 0; !input.isEmpty(); i++) {
            int x = input.readInt();
            int y = input.readInt();
            Point point = new Point(x, y);
            point.draw();
            points[i] = point;
        }

        StdDraw.setPenRadius(LINE_RADIUS);

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
    }

    public BruteCollinearPoints(Point[] points)  {
//        this.points = points;

        List<LineSegment> listOfLineSegments = new ArrayList<>();

        Arrays.sort(points);

        for (int i = 0; i < points.length - 3; i++) { //TODO: what is the upper bound
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

        System.out.println("Line segments:");
        listOfLineSegments.forEach(System.out::println);
    }

    private void addLineSegment(List<LineSegment> lineSegments, Point... points) {
        System.out.println("points[0]" + points[0]);
        System.out.println("points[1]" + points[1]);
        System.out.println("points[2]" + points[2]);
        System.out.println("points[3]" + points[3]);
        System.out.println("points[0].slopeTo(points[1])" + points[0].slopeTo(points[1]));
        System.out.println("points[0].slopeTo(points[2])" + points[0].slopeTo(points[2]));
        System.out.println("points[0].slopeTo(points[3])" + points[0].slopeTo(points[3]));

        lineSegments.add(new LineSegment(points[0], points[1]));
        lineSegments.add(new LineSegment(points[1], points[2]));
        lineSegments.add(new LineSegment(points[2], points[3]));
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public static LineSegment[] segments() {
        return lineSegments;
    }
}
