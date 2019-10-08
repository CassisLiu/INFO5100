package Assignment04;

public class Rectangle extends Shape{

	double length;
	double width;
	public Rectangle(double len, double wi) {
		length = len;
		width = wi;
	}
	@Override
	public void getArea() {
		System.out.println(length * width);
	}
	@Override
	public void getPerimeter() {
		System.out.println(2 * (length + width));
	}
}
