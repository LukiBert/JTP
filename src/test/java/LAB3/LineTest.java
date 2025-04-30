package LAB3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testMove1() {
        Line line = new Line(new Point(0, 0), new Point(1, 1));
        line.move(2, 3);
        assertEquals(new Line(new Point(2, 3), new Point(3, 4)), line);
    }

    @Test
    void testMove2() {
        Line line = new Line(new Point(-1, -1), new Point(1, 1));
        line.move(-1, -1);
        assertEquals(new Line(new Point(-2, -2), new Point(0, 0)), line);
    }

    @Test
    void testMove3() {
        Line line = new Line(new Point(5, 5), new Point(10, 10));
        line.move(0, 0);
        assertEquals(new Line(new Point(5, 5), new Point(10, 10)), line);
    }

    @Test
    void testFlip1() {
        Line line = new Line(new Point(2, -3), new Point(-4, 5));
        line.flip();
        assertEquals(new Line(new Point(-2, 3), new Point(4, -5)), line);
    }

    @Test
    void testFlip2() {
        Line line = new Line(new Point(0, 0), new Point(1, 1));
        line.flip();
        assertEquals(new Line(new Point(0, 0), new Point(-1, -1)), line);
    }

    @Test
    void testFlip3() {
        Line line = new Line(new Point(-2, -2), new Point(-3, -3));
        line.flip();
        assertEquals(new Line(new Point(2, 2), new Point(3, 3)), line);
    }

    @Test
    void testRotate1() {
        Line line = new Line(new Point(1, 0), new Point(0, 1));
        line.rotate(90);
        assertTrue(Math.abs(line.getP1().getX() - 0) < EPSILON &&
                Math.abs(line.getP1().getY() - 1) < EPSILON);
        assertTrue(Math.abs(line.getP2().getX() + 1) < EPSILON &&
                Math.abs(line.getP2().getY() - 0) < EPSILON);
    }

    @Test
    void testRotate2() {
        Line line = new Line(new Point(1, 1), new Point(-1, -1));
        line.rotate(180);
        assertTrue(Math.abs(line.getP1().getX() - (-1)) < EPSILON &&
                Math.abs(line.getP1().getY() - (-1)) < EPSILON);
        assertTrue(Math.abs(line.getP2().getX() - 1) < EPSILON &&
                Math.abs(line.getP2().getY() - 1) < EPSILON);
    }

    @Test
    void testRotate3() {
        Line line = new Line(new Point(1, 0), new Point(0, -1));
        line.rotate(-90);
        assertTrue(Math.abs(line.getP1().getX() - 0) < EPSILON &&
                Math.abs(line.getP1().getY() - (-1)) < EPSILON);
        assertTrue(Math.abs(line.getP2().getX() - (-1)) < EPSILON &&
                Math.abs(line.getP2().getY() - 0) < EPSILON);
    }

    @Test
    void testToString1() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        assertEquals("[(1.0, 1.0), (2.0, 2.0)]", line.toString());
    }

    @Test
    void testToString2() {
        Line line = new Line(new Point(-1.5, 0), new Point(0, -1.5));
        assertEquals("[(-1.5, 0.0), (0.0, -1.5)]", line.toString());
    }

    @Test
    void testToString3() {
        Line line = new Line(new Point(0, 0), new Point(0, 0));
        assertEquals("[(0.0, 0.0), (0.0, 0.0)]", line.toString());
    }

    @Test
    void testEquals1() {
        Line line1 = new Line(new Point(1, 1), new Point(2, 2));
        Line line2 = new Line(new Point(1, 1), new Point(2, 2));
        assertEquals(line1, line2);
    }

    @Test
    void testEquals2() {
        Line line1 = new Line(new Point(1, 1), new Point(2, 2));
        Line line2 = new Line(new Point(2, 2), new Point(3, 3));
        assertNotEquals(line1, line2);
    }

    @Test
    void testEquals3() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        assertNotNull(line);
    }

    @Test
    void testClone1() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        Line cloned = (Line) line.clone();
        assertNotNull(cloned);
    }

    @Test
    void testClone2() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        Line cloned = (Line) line.clone();
        assertEquals(line, cloned);
    }

    @Test
    void testClone3() {
        Line line = new Line(new Point(1, 1), new Point(2, 2));
        Line cloned = (Line) line.clone();
        assertNotSame(line, cloned);
        assertNotSame(line.getP1(), cloned.getP1());
        assertNotSame(line.getP2(), cloned.getP2());
    }
}