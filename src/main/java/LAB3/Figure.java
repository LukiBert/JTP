package LAB3;

public interface Figure {
    void move(double dx, double dy);
    void flip();
    void rotate(double x);
    boolean equals(Object o);
    String toString();
}
