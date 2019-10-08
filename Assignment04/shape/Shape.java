package Assignment04;

public class Shape {
	String name = this.getClass().getName();
	double perimeter;
	double area;
	
	public Shape() {}	
	public void draw() {
		System.out.println("Drawing " + name);
	}
	public void getPerimeter() {
		System.out.println(perimeter);
	}
	public void getArea() {
		System.out.println(area);
	}
}
