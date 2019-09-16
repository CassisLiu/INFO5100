package CourseRegisteration;

import java.util.Random;

public class Course {
	long courseID;
	String name;
	Lecturer lecturer;
	Time time;
	int capacity;
	String description;
	
	public Course(String name, Lecturer lecturer, Time time, int capacity, String description) {
		Random rand = new Random();
		courseID = rand.nextLong();
		this.name = name;
		this.lecturer = lecturer;
		this.capacity = capacity;
		this.time = time;
		this.description = description;
	}

	public void capacityChange(int change) {
		capacity += change;
	}
}
