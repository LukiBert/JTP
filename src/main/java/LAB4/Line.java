package LAB4;

public class Line implements Figure {
    private Point p1;
    private Point p2;

    public Point getP1() { return this.p1; }

    public Point getP2() { return this.p2; }

    @Override
    public void move(double dx, double dy) {
        this.p1.move(dx, dy);
        this.p2.move(dx, dy);
    }

    @Override
    public void flip() {
        this.p1.flip();
        this.p2.flip();
    }

    @Override
    public void rotate(double x) {
        this.p1.rotate(x);
        this.p2.rotate(x);
    }

    @Override
    public String toString() {
        return "[" + this.p1.toString() + ", " + this.p2.toString() + "]";
    }

    @Override
    public Figure clone() {
        return new Line((Point) this.p1.clone(), (Point) this.p2.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Line O = (Line) o;

        return this.p1.equals(O.p1) && this.p2.equals(O.p2);
    }

    Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
