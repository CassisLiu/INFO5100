package Assignment03;

import java.util.Arrays;

public class Course {
	private int courseId;
	private String courseName;
	private int maxCapacity;
	private int professorId;
	private int credits;
	int[] studentIds;
	
	/*
	 * 3 constructors
	 * getter and setters
	 */
	public Course(int courseID) {
		if(courseID > 0)
			courseId = courseID;
	}	
	public Course(int courseID, int professorId) {
		if(courseID > 0)
			courseId = courseID;
		if(professorId > 99999)
			this.professorId = professorId;
	}
	public Course(int courseID, int professorId, int credit) {
		if(courseID > 0)
			courseId = courseID;
		if(professorId > 99999)
			this.professorId = professorId;
		credits = credit;
	}
	

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		if(courseId > 0)
			this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	
	/*
	 * course name should be a string with min length of 10 and max length of 60
	 */
	public void setCourseName(String courseName) {
		if(courseName.length() >= 10 && courseName.length() <= 60)
			this.courseName = courseName;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		if(maxCapacity >= 10 && maxCapacity <= 100)
			this.maxCapacity = maxCapacity;
	}
	public int getProfessorId() {
		return professorId;
	}
	/*
	 * ProfessorId should be a six digit integer
	 */
	public void setProfessorId(int professorId) {
		if(professorId > 99999)
			this.professorId = professorId;
	}
	public double getCredits() {
		return credits;
	}
	/*
	 * credit should be greater than 0 and a single digit
	 */
	public void setCredits(int credits) {
		if(credits > 0 && credits < 10)
			this.credits = credits;
	}
	public int[] getStudentIds() {
		return studentIds;
	}
	/*
	 *  I think studentIds should not have setter, since we can only add student one by one
	 */
	public void setStudentIds() {
		this.studentIds = new int[maxCapacity];
	}
	
	/* 
	 * add the studentID into studentID arrays
	 */
	public void registerStudent(int studentId) {
		if(studentIds.length >= maxCapacity) {
			studentIds = removeDuplicates(studentIds);
		}
		studentIds[studentIds.length] = studentId;
	}
	
	// method 1: sort -> adjacent element, if the same don't copy
	// method 2 use HashSet
	// I don't assign a new int array every time, since adding student and deleting will both
	// do a copy operation, and cost O(n) every time. Instead, I use a fixed size array, and delete 
	// studentId by assigning it 0. It also benefits when adding studentId, will not need to new array with biger size 
	public int[] removeDuplicates(int[] studentIds) {
		Arrays.sort(studentIds);
		// [0,end) is the studentId will be remained
		int end = 1;
		for(int i = 1; i < studentIds.length; i++) {
			if(studentIds[i] != studentIds[end-1]) {
				studentIds[end++] = studentIds[i];
			}
		}
		for(int j = end; j < studentIds.length; j++) {
			studentIds[j] = 0;
		}
		return studentIds;
	}
	
	/* Put odd number in a group, even number in a group 
	 * 
	 */
	public static int groupsOfStudents(int[] studentIds) {
		int odd = 0, even = 0;
		for(int id : studentIds) {
			if(id > 0) {
				if(id % 2 == 0) even++;
				else odd++;
			}
		}
		int sum = 0;
		for(int i = 1; i < odd; i++) sum += i;
		for(int j = 1; j < even; j++) sum+= j;
		return sum;
	}
	
	// test
	public static void main(String[] args) {
		int[] stu = new int[] {1,2,3,4,5,6};
		int sum = groupsOfStudents(stu);
		System.out.print(sum);
	}
}
