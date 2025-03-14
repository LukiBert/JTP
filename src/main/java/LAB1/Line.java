package LAB1;

public class Line {
	private Point p1;
	private Point p2;

	public Point getP1() { return this.p1; }
	public Point getP2() { return this.p2; }

	public void move(double xm, double ym) {
		this.p1.move(xm, ym);
		this.p2.move(xm, ym);
	}
	
	public void flip() {
		this.p1.flip();
		this.p2.flip();
	}
	
	@Override
	public String toString() {
		return this.p1.toString() + ", " + this.p2.toString();
	}
	
	public void rotate(double a) {
		this.p1.rotate(a);
		this.p2.rotate(a);
	}
	
	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public static void main(String[] args) {
		// Test comment for IDE
		// Test comment for console

		Point a = new Point(2.0, 4.0);
		Point b = new Point(-1.0, -2.0);
		System.out.println(a + ", " + b);
		
		Line l = new Line(a, b);		
		l.move(1.0, 1.0);
		System.out.println(l);
	}
}
