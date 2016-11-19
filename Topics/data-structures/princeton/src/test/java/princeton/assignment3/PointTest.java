package princeton.assignment3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void compareShouldReturnOneIfFirstPointIsHigher() {
        //given
        Point firstPoint = new Point(3, 5);
        Point secondPoint = new Point(2, 2);

        //when
        int comparisonResult = firstPoint.compareTo(secondPoint);

        //then
        assertThat(comparisonResult, is(1));
    }

    @Test
    public void compareShouldReturnNegativeOneIfTheFirstPointIsLower() {
        //given
        Point firstPoint = new Point(2, 2);
        Point secondPoint = new Point(2, 5);

        //when
        int comparisonResult = firstPoint.compareTo(secondPoint);

        //then
        assertThat(comparisonResult, is(-1));
    }

    @Test
    public void compareShouldReturnNegativeOneIfTheFirstPointHasBiggerXCoordinateButEqualY() {
        //given
        Point firstPoint = new Point(2, 3);
        Point secondPoint = new Point(5, 3);

        //when
        int comparisonResult = firstPoint.compareTo(secondPoint);

        //then
        assertThat(comparisonResult, is(-1));
    }

    @Test
    public void compareShouldReturnPositiveOneIfTheFirstPointHasBiggerXCoordinateButEqualY() {
        //given
        Point firstPoint = new Point(5, 3);
        Point secondPoint = new Point(2, 3);

        //when
        int comparisonResult = firstPoint.compareTo(secondPoint);

        //then
        assertThat(comparisonResult, is(1));
    }

    @Test
    public void shouldComparePointsByTheirSlopes() {
        //given
        Point firstPoint  = new Point(3, 6);
        Point secondPoint = new Point(5, 3);
        Point thirdPoint  = new Point(2, 3);
        Point forthPoint  = new Point(1, 7);
        Point fifthPoint  = new Point(7, 3);
        Point sixthPoint  = new Point(2, 4);

        List<Point> points = asList(firstPoint,
                secondPoint, thirdPoint, forthPoint, fifthPoint, sixthPoint);

        //when
        points.sort((p1, p2) -> (p1.compareTo(p2)));

        //then
    }

    @Test
    public void streamTest() {

        List<Point> points = Arrays.asList(new Point(2, 5), new Point(2, 4), new Point(4, 6), new Point(2, 6),
                new Point(4, 8), new Point(6, 10), new Point(8, 12), new Point(4, 12), new Point(7, 3));
        Point[] pointArray =(Point []) points.toArray();

        List<LineSegment> lineSegments = new ArrayList<>();

        for (int i = 0; i < pointArray.length - 3; i++) {
            System.out.println("In for loop addLineSegments(lineSegments, pointArray[i],\n" +
                    "                    pointArray[i + 1], pointArray[i + 2], pointArray[i + 3]);" + i +" "
                    + i + 1 + " " + i + 2 + " " + i + 3);
            addLineSegments(lineSegments, pointArray[i],
                    pointArray[i + 1], pointArray[i + 2], pointArray[i + 3]);
        }

        System.out.println(lineSegments);
    }

    private void addLineSegments(List<LineSegment> lineSegments, Point... points) {
        if(getSlope(points[0], points[1]) == getSlope(points[0], points[2])
                && getSlope(points[0], points[1]) == getSlope(points[0], points[3])) {

            System.out.println("(points[0], points[1]): " + points[0] + points[1]);
            System.out.println("(points[0], points[2]): " + points[0] + points[2]);
            System.out.println("(points[0], points[3]): " + points[0] + points[3]);

            System.out.println();

            System.out.println("getSlope(Point p1, Point p2): " + getSlope(points[0], points[1]));
            System.out.println("getSlope(Point p1, Point p2): " + getSlope(points[0], points[2]));
            System.out.println("getSlope(Point p1, Point p2): " + getSlope(points[0], points[3]));

            lineSegments.add(new LineSegment(points[0], points[1]));
            lineSegments.add(new LineSegment(points[1], points[2]));
            lineSegments.add(new LineSegment(points[2], points[3]));
        }
    }

    private final BiFunction<Point, Point, Double> pointIntegerFunction = Point::slopeTo;

    private double getSlope(Point p1, Point p2) {
        return pointIntegerFunction.apply(p1, p2);
    }

    //Objects.equals(pointIntegerFunction.apply(points[0], points[1]),
//                pointIntegerFunction.apply(points[0], points[2]));
}