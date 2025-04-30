package LAB3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygonTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testMove1() {
        Polygon poly = new Polygon(new Point[] {
                new Point(0, 0), new Point(1, 1), new Point(2, 2)
        });
        poly.move(1, 1);
        assertEquals(new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2), new Point(3, 3)
        }), poly);
    }

    @Test
    void testMove2() {
        Polygon poly = new Polygon(new Point[] {
                new Point(-1, -1), new Point(-2, -2)
        });
        poly.move(2, 3);
        assertEquals(new Polygon(new Point[] {
                new Point(1, 2), new Point(0, 1)
        }), poly);
    }

    @Test
    void testMove3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(5, 5), new Point(0, 0)
        });
        poly.move(0, 0);
        assertEquals(new Polygon(new Point[] {
                new Point(5, 5), new Point(0, 0)
        }), poly);
    }

    @Test
    void testFlip1() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, -2), new Point(-3, 4)
        });
        poly.flip();
        assertEquals(new Polygon(new Point[] {
                new Point(-1, 2), new Point(3, -4)
        }), poly);
    }

    @Test
    void testFlip2() {
        Polygon poly = new Polygon(new Point[] {
                new Point(0, 0), new Point(1, 1)
        });
        poly.flip();
        assertEquals(new Polygon(new Point[] {
                new Point(0, 0), new Point(-1, -1)
        }), poly);
    }

    @Test
    void testFlip3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(-2, -2), new Point(-3, -3)
        });
        poly.flip();
        assertEquals(new Polygon(new Point[] {
                new Point(2, 2), new Point(3, 3)
        }), poly);
    }

    @Test
    void testRotate1() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 0), new Point(0, 1)
        });
        poly.rotate(90);
        Point[] pts = poly.getPoints();
        assertTrue(Math.abs(pts[0].getX() - 0) < EPSILON &&
                Math.abs(pts[0].getY() - 1) < EPSILON);
        assertTrue(Math.abs(pts[1].getX() - (-1)) < EPSILON &&
                Math.abs(pts[1].getY() - 0) < EPSILON);
    }

    @Test
    void testRotate2() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(-1, -1)
        });
        poly.rotate(180);
        Point[] pts = poly.getPoints();
        assertTrue(Math.abs(pts[0].getX() + 1) < EPSILON &&
                Math.abs(pts[0].getY() + 1) < EPSILON);
        assertTrue(Math.abs(pts[1].getX() - 1) < EPSILON &&
                Math.abs(pts[1].getY() - 1) < EPSILON);
    }

    @Test
    void testRotate3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 0), new Point(0, -1)
        });
        poly.rotate(-90);
        Point[] pts = poly.getPoints();
        assertTrue(Math.abs(pts[0].getX() - 0) < EPSILON &&
                Math.abs(pts[0].getY() + 1) < EPSILON);
        assertTrue(Math.abs(pts[1].getX() + 1) < EPSILON &&
                Math.abs(pts[1].getY() - 0) < EPSILON);
    }

    @Test
    void testToString1() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        assertEquals("{ (1.0, 1.0)(2.0, 2.0) }", poly.toString());
    }

    @Test
    void testToString2() {
        Polygon poly = new Polygon(new Point[] {
                new Point(-1.5, 0), new Point(0, -1.5)
        });
        assertEquals("{ (-1.5, 0.0)(0.0, -1.5) }", poly.toString());
    }

    @Test
    void testToString3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(0, 0), new Point(0, 0)
        });
        assertEquals("{ (0.0, 0.0)(0.0, 0.0) }", poly.toString());
    }

    @Test
    void testEquals1() {
        Polygon poly1 = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        assertEquals(poly1, poly2);
    }

    @Test
    void testEquals2() {
        Polygon poly1 = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        Polygon poly2 = new Polygon(new Point[] {
                new Point(3, 3), new Point(4, 4)
        });
        assertNotEquals(poly1, poly2);
    }

    @Test
    void testEquals3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        assertNotNull(poly);
    }
    
    @Test
    void testClone1() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        Polygon cloned = (Polygon) poly.clone();
        assertNotNull(cloned);
    }

    @Test
    void testClone2() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        Polygon cloned = (Polygon) poly.clone();
        assertEquals(poly, cloned);
    }

    @Test
    void testClone3() {
        Polygon poly = new Polygon(new Point[] {
                new Point(1, 1), new Point(2, 2)
        });
        Polygon cloned = (Polygon) poly.clone();
        assertNotSame(poly, cloned);
        assertNotSame(poly.getPoints()[0], cloned.getPoints()[0]);
        assertNotSame(poly.getPoints()[1], cloned.getPoints()[1]);
    }
}