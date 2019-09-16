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
}
