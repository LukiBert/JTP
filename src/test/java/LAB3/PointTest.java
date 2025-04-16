package LAB3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testMove1() {
        Point p = new Point(1, 1);
        p.move(2, 3);
        assertEquals(new Point(3, 4), p);
    }
    @Test
    void testMove2() {
        Point p = new Point(0, 0);
        p.move(-1, -1);
        assertEquals(new Point(-1, -1), p);
    }
    @Test
    void testMove3() {
        Point p = new Point(5, -2);
        p.move(0, 0);
        assertEquals(new Point(5, -2), p);
    }
    @Test
    void testFlip1() {
        Point p = new Point(2, 3);
        p.flip();
        assertEquals(new Point(-2, -3), p);
    }

    @Test
    void testFlip2() {
        Point p = new Point(-1, -1);
        p.flip();
        assertEquals(new Point(1, 1), p);
    }

    @Test
    void testFlip3() {
        Point p = new Point(0, 0);
        p.flip();
        assertEquals(new Point(0, 0), p);
    }

    @Test
    void testRotate1() {
        Point p = new Point(1, 0);
        p.rotate(90);
        assertTrue(Math.abs(p.getX() - 0) < EPSILON && Math.abs(p.getY() - 1) < EPSILON);
    }

    @Test
    void testRotate2() {
        Point p = new Point(0, 1);
        p.rotate(-90);
        assertTrue(Math.abs(p.getX() - 1) < EPSILON && Math.abs(p.getY() - 0) < EPSILON);
    }

    @Test
    void testRotate3() {
        Point p = new Point(1, 1);
        p.rotate(180);
        assertTrue(Math.abs(p.getX() - (-1)) < EPSILON && Math.abs(p.getY() - (-1)) < EPSILON);
    }

    @Test
    void testEquals1() {
        assertEquals(new Point(1, 1), new Point(1, 1));
    }

    @Test
    void testEquals2() {
        assertNotEquals(new Point(1, 1), new Point(2, 2));
    }

    @Test
    void testEquals3() {
        assertNotEquals(new Point(3, 4), null);
    }

    @Test
    void testToString1() {
        assertEquals("(1.0, 1.0)", new Point(1, 1).toString());
    }

    @Test
    void testToString2() {
        assertEquals("(2.0, 2.0)", new Point(2, 2).toString());
    }

    @Test
    void testToString3() {
        assertEquals("(3.0, 4.0)", new Point(3, 4).toString());
    }
}