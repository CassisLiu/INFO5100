package Assignment04;

public class Square extends Shape {
	double length;
	public Square(double length) {
		this.length = length;
	}
	@Override
	public void getArea() {
		System.out.println(length * length);
	}
	@Override
	public void getPerimeter() {
		System.out.println( 4 * length);
	}
}
