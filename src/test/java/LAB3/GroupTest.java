package LAB3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private static final double EPSILON = 1e-9;

    @Test
    void testMove1() {
        Figure[] figures = {
                new Point(1, 1),
                new Line(new Point(0, 0), new Point(1, 1))
        };
        Group group = new Group(figures);
        group.move(1, 1);
        Figure[] expected = {
                new Point(2, 2),
                new Line(new Point(1, 1), new Point(2, 2))
        };
        assertEquals(new Group(expected), group);
    }

    @Test
    void testMove2() {
        Group group = new Group(new Figure[] {
                new Polygon(new Point[] { new Point(0, 0), new Point(1, 1) })
        });
        group.move(2, -1);
        assertEquals(new Group(new Figure[] {
                new Polygon(new Point[] { new Point(2, -1), new Point(3, 0) })
        }), group);
    }

    @Test
    void testMove3() {
        Group group = new Group(new Figure[] {
                new Point(0, 0)
        });
        group.move(0, 0);
        assertEquals(new Group(new Figure[] {
                new Point(0, 0)
        }), group);
    }

    @Test
    void testFlip1() {
        Group group = new Group(new Figure[] {
                new Point(1, -1),
                new Point(-2, 3)
        });
        group.flip();
        assertEquals(new Group(new Figure[] {
                new Point(-1, 1),
                new Point(2, -3)
        }), group);
    }

    @Test
    void testFlip2() {
        Group group = new Group(new Figure[] {
                new Polygon(new Point[] {
                        new Point(2, -2), new Point(-3, 4)
                })
        });
        group.flip();
        assertEquals(new Group(new Figure[] {
                new Polygon(new Point[] {
                        new Point(-2, 2), new Point(3, -4)
                })
        }), group);
    }

    @Test
    void testFlip3() {
        Group group = new Group(new Figure[] {
                new Line(new Point(0, 0), new Point(1, 1))
        });
        group.flip();
        assertEquals(new Group(new Figure[] {
                new Line(new Point(0, 0), new Point(-1, -1))
        }), group);
    }

    @Test
    void testRotate1() {
        Group group = new Group(new Figure[] {
                new Point(1, 0)
        });
        group.rotate(90);
        Point result = (Point) group.getFigures()[0];
        assertTrue(Math.abs(result.getX() - 0) < EPSILON &&
                Math.abs(result.getY() - 1) < EPSILON);
    }

    @Test
    void testRotate2() {
        Group group = new Group(new Figure[] {
                new Line(new Point(1, 0), new Point(0, 1))
        });
        group.rotate(90);
        Line rotated = (Line) group.getFigures()[0];
        assertTrue(Math.abs(rotated.getP1().getX() - 0) < EPSILON &&
                Math.abs(rotated.getP1().getY() - 1) < EPSILON);
        assertTrue(Math.abs(rotated.getP2().getX() - (-1)) < EPSILON &&
                Math.abs(rotated.getP2().getY() - 0) < EPSILON);
    }

    @Test
    void testRotate3() {
        Group group = new Group(new Figure[] {
                new Polygon(new Point[] {
                        new Point(1, 1), new Point(-1, -1)
                })
        });
        group.rotate(180);
        Polygon rotated = (Polygon) group.getFigures()[0];
        assertTrue(Math.abs(rotated.getPoints()[0].getX() + 1) < EPSILON);
        assertTrue(Math.abs(rotated.getPoints()[0].getY() + 1) < EPSILON);
        assertTrue(Math.abs(rotated.getPoints()[1].getX() - 1) < EPSILON);
        assertTrue(Math.abs(rotated.getPoints()[1].getY() - 1) < EPSILON);
    }

    @Test
    void testToString1() {
        Group group = new Group(new Figure[] {
                new Point(1, 1),
                new Point(2, 2)
        });
        assertEquals("< (1.0, 1.0)(2.0, 2.0) >", group.toString());
    }

    @Test
    void testToString2() {
        Group group = new Group(new Figure[] {
                new Polygon(new Point[] {
                        new Point(1, 1)
                })
        });
        assertEquals("< { (1.0, 1.0) } >", group.toString());
    }

    @Test
    void testToString3() {
        Group group = new Group(new Figure[] {
                new Line(new Point(1, 1), new Point(2, 2))
        });
        assertEquals("< [(1.0, 1.0), (2.0, 2.0)] >", group.toString());
    }

    @Test
    void testEquals1() {
        Group g1 = new Group(new Figure[] {
                new Point(1, 1),
                new Line(new Point(0, 0), new Point(1, 1))
        });
        Group g2 = new Group(new Figure[] {
                new Point(1, 1),
                new Line(new Point(0, 0), new Point(1, 1))
        });
        assertEquals(g1, g2);
    }

    @Test
    void testEquals2() {
        Group g1 = new Group(new Figure[] {
                new Point(1, 1)
        });
        Group g2 = new Group(new Figure[] {
                new Point(2, 2)
        });
        assertNotEquals(g1, g2);
    }

    @Test
    void testEquals3() {
        Group g1 = new Group(new Figure[] {
                new Point(0, 0)
        });
        assertNotNull(g1);
    }

    @Test
    void testClone1() {
        Group group = new Group(new Figure[] {
                new Point(1, 1)
        });
        Group cloned = (Group) group.clone();
        assertNotNull(cloned);
    }

    @Test
    void testClone2() {
        Group group = new Group(new Figure[] {
                new Point(1, 1),
                new Line(new Point(0, 0), new Point(1, 1))
        });
        Group cloned = (Group) group.clone();
        assertEquals(group, cloned);
    }

    @Test
    void testClone3() {
        Group group = new Group(new Figure[] {
                new Polygon(new Point[] { new Point(1, 1), new Point(2, 2) })
        });
        Group cloned = (Group) group.clone();
        assertNotSame(group, cloned);
        assertNotSame(group.getFigures()[0], cloned.getFigures()[0]);
    }
}