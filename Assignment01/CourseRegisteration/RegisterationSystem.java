package CourseRegisteration;

import java.util.List;
import java.util.Map;

public class RegisterationSystem {
	Map<Long, Course> courses;
	List<Student> students;
	
	public Course getCourse(long courseID) {
		return courses.get(courseID);
	}
}
