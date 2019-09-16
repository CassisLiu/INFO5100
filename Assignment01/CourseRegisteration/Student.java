package CourseRegisteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Student {
	long studentID;
	String name;
	List<Course> myCourses;
	RegisterationSystem sys;
	
	public Student(String name) {
		Random rand = new Random();
		studentID = rand.nextLong();
		this.name = name;
		myCourses = new ArrayList<>();
		RegisterationSystem sys = new RegisterationSystem();
		sys.students.add(this);
	}
	
	public Course searchCourse(long courseID) {
		Map<Long, Course> courseInSystem = sys.courses;
		return courseInSystem.get(courseID);
	}
	
	public boolean registerACourse(long courseID) {
		Course course = sys.courses.get(courseID);
		if(course != null && course.capacity > 0) {
			// course.capacity--; 这个地方只改了这个method里的capacity没有修改
			course.capacityChange(-1);
			sys.courses.put(courseID, course);
			myCourses.add(course);
			
		}
		return false;
	}
	
	public boolean unregister(long courseID) {
		// If student list contains the course of which ID is courseID, 
		// delete the course from myCourses and return true
		return false;
	}
	
	public String checkCourseDescription(long courseID) {
		/* Find in the courseInSystem by courseID
		 * Return the found course description
		 */
		return new String();
	}
	public String searchLecturer(Lecturer lecturer) {
		/*
		 * Find in the lecturer list, return the description of the found lecturer
		 */
		return new String();
	}
}
