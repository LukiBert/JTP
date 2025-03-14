package LAB1;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @org.junit.jupiter.api.Test
    void testMove1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Line line = new Line(p1, p2);
        line.move(1, 1);
        assert(line.getP1().getX() == 1 && line.getP1().getY() == 1
                && line.getP2().getX() == 1 && line.getP2().getY() == 3);
    }

    @org.junit.jupiter.api.Test
    void testMove2() {
        Point p1 = new Point(-2, 4);
        Point p2 = new Point(5, -1);
        Line line = new Line(p1, p2);
        line.move(-1, 0);
        assert(line.getP1().getX() == -3 && line.getP1().getY() == 4
                && line.getP2().getX() == 4 && line.getP2().getY() == -1);
    }

    @org.junit.jupiter.api.Test
    void testFlip1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-2, -2);
        Line line = new Line(p1, p2);
        line.flip();
        assert(line.getP1().getX() == -1 && line.getP1().getY() == -1
                && line.getP2().getX() == 2 && line.getP2().getY() == 2);
    }

    @org.junit.jupiter.api.Test
    void testFlip2() {
        Point p1 = new Point(-1, 1);
        Point p2 = new Point(2, -2);
        Line line = new Line(p1, p2);
        line.flip();
        assert(line.getP1().getX() == 1 && line.getP1().getY() == -1
                && line.getP2().getX() == -2 && line.getP2().getY() == 2);
    }

    @org.junit.jupiter.api.Test
    void testRotate1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, -1);
        Line line = new Line(p1, p2);
        line.rotate(90);
        System.out.println(line);
        assert(line.getP1().getX() - (-1) < 1e-9 && Math.abs(line.getP1().getY() - 1) < 1e-9
                && Math.abs(line.getP2().getX() - 1) < 1e-9 && Math.abs(line.getP2().getY() - (-1)) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate2() {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(-3, -4);
        Line line = new Line(p1, p2);
        line.rotate(180);
        System.out.println(line);
        assert(Math.abs(line.getP1().getX() - (-3)) < 1e-9 && Math.abs(line.getP1().getY() - (-4)) < 1e-9
                && Math.abs(line.getP2().getX() - 3) < 1e-9 && Math.abs(line.getP2().getY() - 4) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate3() {
        Point p1 = new Point(0, 5);
        Point p2 = new Point(0, -5);
        Line line = new Line(p1, p2);
        line.rotate(270);
        System.out.println(line);
        assert(Math.abs(line.getP1().getX() - 5) < 1e-9 && Math.abs(line.getP1().getY() - 0) < 1e-9
                && Math.abs(line.getP2().getX() - (-5)) < 1e-9 && Math.abs(line.getP2().getY() - 0) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate4() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(-2, 0);
        Line line = new Line(p1, p2);
        line.rotate(90);
        System.out.println(line);
        assert(Math.abs(line.getP1().getX() - 0) < 1e-9 && Math.abs(line.getP1().getY() - 2) < 1e-9
                && Math.abs(line.getP2().getX() - 0) < 1e-9 && Math.abs(line.getP2().getY() - (-2)) < 1e-9);
    }
}