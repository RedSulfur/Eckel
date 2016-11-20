package princeton.assignment3;

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

    private static final BiFunction<Point, Point, Double> SLOPE_BETWEEN_POINTS_BIFUNCTION = Point::slopeTo;

    private static Point[] points;
    private static LineSegment[] lineSegments;

    public static void main(String[] args) throws IOException {
        populatePointsArray();
        new BruteCollinearPoints();
    }

    private static void populatePointsArray() throws IOException {
        Pattern p = Pattern.compile("\\d+");

        Stream<String> stream = lines(get("/home/serhii/old-system/" +
                "old-system/IdeaProjects/Eckel/Topics/data-structures/princeton/" +
                "src/main/java/princeton/assignment3/input400.txt"));
        List<String> strings = stream.skip(1).collect(Collectors.toList());
//        strings.forEach(System.out::println);
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

    public BruteCollinearPoints(/*Point[] points*/)  {
//        this.points = points;

        List<LineSegment> listOfLineSegments = new ArrayList<>();

        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) { //TODO: what is the upper bound
            Point p = points[i];
            for (int j = i + 1; j < points.length; j++) {
                double slopePQ = p.slopeTo(points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {

                    }
                }
            }


            addLineSegments(listOfLineSegments, points[i],
                    points[i + 1], points[i + 2], points[i + 3]);
        }

        lineSegments = listOfLineSegments.toArray(new LineSegment[listOfLineSegments.size()]);
        System.out.println("Constructed line segments");
        listOfLineSegments.forEach(System.out::println);
    }

    private void addLineSegments(List<LineSegment> lineSegments, Point... points) {
        System.out.println("points[0]" + points[0]);
        System.out.println("points[1]" + points[1]);
        System.out.println("points[2]" + points[2]);
        System.out.println("points[3]" + points[3]);
        System.out.println("points[0].slopeTo(points[1])" + points[0].slopeTo(points[1]));
        System.out.println("points[0].slopeTo(points[2])" + points[0].slopeTo(points[2]));
        System.out.println("points[0].slopeTo(points[3])" + points[0].slopeTo(points[3]));
        if(isSlopeBetweenPointsEqual(points[0], points[1], points[2])
                && isSlopeBetweenPointsEqual(points[0], points[1], points[3])) {

//            System.out.println("points[0]" + points[0]);
//            System.out.println("points[1]" + points[1]);
//            System.out.println("points[2]" + points[2]);
//            System.out.println("points[3]" + points[3]);
//            System.out.println("points[0].slopeTo(points[1])" + points[0].slopeTo(points[1]));
//            System.out.println("points[0].slopeTo(points[2])" + points[0].slopeTo(points[2]));
//            System.out.println("points[0].slopeTo(points[3])" + points[0].slopeTo(points[3]));
            lineSegments.add(new LineSegment(points[0], points[1]));
            lineSegments.add(new LineSegment(points[1], points[2]));
            lineSegments.add(new LineSegment(points[2], points[3]));
        }
    }

    private boolean isSlopeBetweenPointsEqual(Point p1, Point p2, Point p3) {
        return getSlope(p1, p2) == getSlope(p1, p3);
    }

    private double getSlope(Point p1, Point p2) {
        return SLOPE_BETWEEN_POINTS_BIFUNCTION.apply(p1, p2);
    }

    public int numberOfSegments() {
        return lineSegments.length;
    }

    public static LineSegment[] segments() {
        return lineSegments;
    }
}
