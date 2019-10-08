package Assignment04;

public class Circle extends Shape {
	double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public void getPerimeter() {
		System.out.println(3.14 * 2 * radius);
	}
	@Override
	public void getArea() {
		System.out.println(3.14 * radius * radius);
	}
}
