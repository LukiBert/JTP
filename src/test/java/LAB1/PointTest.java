package LAB1;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @org.junit.jupiter.api.Test
    void testMove1() {
        double x = 1;
        double y = 1;
        double a = 2;
        double b = 2;
        Point p1 = new Point(x, y);
        p1.move(a, b);
        assert(p1.getX() == 3 && p1.getY() == 3);
    }

    @org.junit.jupiter.api.Test
    void testMove2() {
        double x = -10;
        double y = 8;
        double a = 0;
        double b = -2;
        Point p1 = new Point(x, y);
        p1.move(a, b);
        assert(p1.getX() == -10 && p1.getY() == 6);
    }

    @org.junit.jupiter.api.Test
    void testFlip1() {
        double x = 1;
        double y = 1;
        Point p1 = new Point(x, y);
        p1.flip();
        assert(p1.getX() == -1 && p1.getY() == -1);
    }

    @org.junit.jupiter.api.Test
    void testFlip2() {
        double x = -1;
        double y = 1;
        Point p1 = new Point(x, y);
        p1.flip();
        assert(p1.getX() == 1 && p1.getY() == -1);
    }

    @org.junit.jupiter.api.Test
    void testRotate1() {
        double x = 1;
        double y = 1;
        double a = -1;
        double b = 1;
        Point p1 = new Point(x, y);
        p1.rotate(90);
        System.out.println(p1);
        assert(Math.abs(p1.getX() - a) < 1e-9 && Math.abs(p1.getY() - b) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate2() {
        double x = 0;
        double y = 0;
        double a = 0;
        double b = 0;
        Point p1 = new Point(x, y);
        p1.rotate(180);
        System.out.println(p1);
        assert(Math.abs(p1.getX() - a) < 1e-9 && Math.abs(p1.getY() - b) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate3() {
        double x = 1;
        double y = 1;
        double a = -1;
        double b = -1;
        Point p1 = new Point(x, y);
        p1.rotate(180);
        System.out.println(p1);
        assert(Math.abs(p1.getX() - a) < 1e-9 && Math.abs(p1.getY() - b) < 1e-9);
    }

    @org.junit.jupiter.api.Test
    void testRotate4() {
        double x = 1;
        double y = 1;
        double a = 1;
        double b = -1;
        Point p1 = new Point(x, y);
        p1.rotate(270);
        System.out.println(p1);
        assert(Math.abs(p1.getX() - a) < 1e-9 && Math.abs(p1.getY() - b) < 1e-9);
    }
}