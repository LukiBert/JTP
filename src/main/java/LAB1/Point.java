package LAB1;

public class Point {
	private double x;
	private double y;
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void move(double xm, double ym) {
		this.x += xm;
		this.y += ym;
	}
	
	public void flip() {
		this.x = -this.x;
		this.y = -this.y;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public void rotate(double degrees) {
		double radian = Math.toRadians(degrees);
		if(0.0 <= radian && radian < 2 * Math.PI) {
			double new_x = this.x * Math.cos(radian) - this.y * Math.sin(radian);
			double new_y = this.x * Math.sin(radian) + this.y * Math.cos(radian);
			this.x = new_x;
			this.y = new_y;
		}
	}
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
