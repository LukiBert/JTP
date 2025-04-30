package LAB3;

public class Polygon implements Figure {
    private Point[] points;

    public Point[] getPoints() { return this.points; }

    @Override
    public void move(double dx, double dy) {
        for (Point p : this.points) {
            p.move(dx, dy);
        }
    }

    @Override
    public void flip() {
        for (Point p : this.points) {
            p.flip();
        }
    }

    @Override
    public void rotate(double x) {
        for (Point p : this.points) {
            p.rotate(x);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for (Point p : this.points) {
            builder.append(p);
        }
        builder.append(" }");
        return builder.toString();
    }

    @Override
    public Figure clone() {
        Point[] clonedPoints = new Point[this.points.length];
        for (int i = 0; i < this.points.length; i++) {
            clonedPoints[i] = (Point) this.points[i].clone();
        }
        return new Polygon(clonedPoints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Polygon O = (Polygon) o;
        Point[] Opoints = O.getPoints();

        boolean equals = true;

        for (int i = 0; i < this.points.length; i++) {
            if (!this.points[i].equals(Opoints[i])) {
                equals = false;
                break;
            }
        }

        return equals;
    }

    Polygon(Point[] points) {
        this.points = points;
    }
}
