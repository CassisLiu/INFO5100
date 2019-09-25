package Assignment02;

public class Assignment2 {
	/*
    	This method should return the sum of salaries of employees having salary greater than 5000
    	Note: Employee array is passed, not employee
	 */
	public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sum = 0.0;
		for(Employee em : employees) {
        	if(em.getSalary() > 5000) {
        		sum += em.getSalary();
        	}
        }
        return sum;
    }

    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        int id = employee.getId();
        if(id % 3 == 0 && id % 5 == 0) System.out.println("FizzBuzz");
        else if(id % 3 == 0) System.out.println("Fizz");
        else if(id % 5 == 0) System.out.println("Buzz");
    }

    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        double salary = employee.getSalary(), tax = 0.0;
        if(salary <= 2500.0) tax = salary * 0.1;
        else if(salary > 2500.0 && salary <= 5000.0) tax = salary * 0.25;
        else tax = salary * 0.35;
        return tax;
    }

    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double tmp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(tmp);
    }

    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        int count = 0;
    	for(Employee em : employees) {
    		if(em.getAge() > 50) count++;
    	}
        return count;
    }
    /*
    Implement this method to reverse firstName of employee.
    Ex. Before: employee.getFirstName() -> "John"
    After : employee.getFirstName() -> "nhoJ"
 */
  public void reverseFirstName(Employee employee) {
	  String name = employee.getFirstName();
	  if(name == null || name.length() <= 1) return ;
	  char[] arr = name.toCharArray();
	  int i = 0, j = arr.length - 1;
	  while(i < j) { 
		  char tmp = arr[i];
		  arr[i++] = arr[j];
		  arr[j--] = tmp;
	  }
	  employee.setFirstName(new String(arr));
	  
  }


/*
    Print "true" if employee's first name contain one or more digits
    Print "false" if employee's first name doesn't contain any digit
    Ex: employee.getFirstName() -> "ha8l" == true
    employee.getFirstName() -> "hail" == false
 */
  public void isContainDigit(Employee employee) {
	  // @TODO
	  String name = employee.getFirstName();
	  if(name == null || name.length() == 0) System.out.println("false");
	  
	  for(char ch : name.toCharArray()) {
		  if(Character.isDigit(ch)) {
			  System.out.println("true");
			  return ;
		  }
	  }
	  
	  System.out.println("false");
  }


 /*
    Write a method to raise an employee's salary to three times of his/her original salary.
    Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
    DO NOT change the input in this method.
    Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
    Call this new method.
 */
  public void tripleSalary(Employee employee) {
	  // @TODO
	  employee.raiseSalary(3.0);
  }


//Additional question for extra credit
/*
    Implement this method to convert String[] to employees array.
    Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
    This String array of length 2 contains 2 employees in form of string, where
    id = 1
    firstName=John
    age=24
    salary=7500
    convert each string to employee object.
    Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 */
public Employee[] createEmployees(String[] employeesStr) {
	if(employeesStr == null) return new Employee[1];
	int num = employeesStr.length;
    Employee[] employees = new Employee[num];
    // @TODO
    String[][] info = new String[num][4];
    for(int i = 0; i < num; i++) {
    	info[i] = employeesStr[i].split(",");
    	int id = Integer.valueOf(info[i][0]);
    	String name = info[i][1];
    	int age = Integer.valueOf(info[i][2]);
    	double salary = Double.valueOf(info[i][3]);
    	employees[i] = new Employee(id, name, age, salary);
    }
    return employees;
}
}

