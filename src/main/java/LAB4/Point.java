package LAB4;

public class Point implements Figure {
    private double x;
    private double y;

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void flip() {
        this.x = -this.x;
        this.y = -this.y;
    }

    @Override
    public void rotate(double x) {
        double radian = Math.toRadians(x);
        double new_x = this.x * Math.cos(radian) - this.y * Math.sin(radian);
        double new_y = this.x * Math.sin(radian) + this.y * Math.cos(radian);
        this.x = new_x;
        this.y = new_y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public Figure clone() {
        return new Point(this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) { return false; }

        Point O = (Point) o;

        return this.x == O.x && this.y == O.y;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
