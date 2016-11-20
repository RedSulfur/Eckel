package princeton.assignment3;

import edu.princeton.cs.algs4.StdDraw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;

@SuppressWarnings("Duplicates")
public class FastCollinearPoints {

    private final static int MAX_SCALE_VALUE = 32768;
    /**
     * Constant holding radius for points drawing
     */
    private static final double POINT_RADIUS = 0.003;
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

        populatePointsArray();

        for (Point point : points) {
            point.draw();
        }

        StdDraw.setPenRadius(LINE_RADIUS);

        new BruteCollinearPoints(points);
    }

    private static void populatePointsArray() throws IOException {
        Pattern p = Pattern.compile("\\d+");

        Stream<String> stream = lines(get("/home/serhii/old-system/" +
                "old-system/IdeaProjects/Eckel/Topics/data-structures/princeton/" +
                "src/main/java/princeton/assignment3/rs1423.txt"));
        List<String> strings = stream.skip(1).collect(Collectors.toList());
        List<Point> pointsList = strings.stream().map(s -> {
            Matcher m = p.matcher(s);
            List<String> list = new ArrayList<>();
            while (m.find()) {
                list.add(m.group(0));
            }
            return new Point(Integer.valueOf(list.get(0)), Integer.valueOf(list.get(1)));
        }).collect(Collectors.toList());

        points = pointsList.toArray(new Point[pointsList.size()]);
    }

    public FastCollinearPoints(Point[] points)  {

        List<LineSegment> listOfLineSegments = new ArrayList<>();
        LinkedList<Point> pointLinkedList = new LinkedList<>();
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];

            Point[] adjacentPoints = copyOfRange(points, i + 1, points.length);
            sort(adjacentPoints, p.slopeOrder());

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
    }
























    private void addLineSegment(List<LineSegment> lineSegments, Point... points) {
        System.out.println("points[0]: " + points[0]);
        System.out.println("points[1]: " + points[1]);
        System.out.println("points[2]: " + points[2]);
        System.out.println("points[3]: " + points[3]);
        System.out.println("points[0].slopeTo(points[1]) = " + points[0].slopeTo(points[1]));
        System.out.println("points[0].slopeTo(points[2]) = " + points[0].slopeTo(points[2]));
        System.out.println("points[0].slopeTo(points[3]) = " + points[0].slopeTo(points[3]));

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
