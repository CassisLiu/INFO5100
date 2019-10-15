package Assignment05;

public class Contractor extends Employee {
	private int workingHours;
	public Contractor(String name, int paymentPerHour, int workingHours) {
		super(name, paymentPerHour);
		// TODO Auto-generated constructor stub
		this.workingHours = workingHours;
	}
	
	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	@Override
	public int calculateSalary() {
		// TODO Auto-generated method stub
		return getPaymentPerHour()  * workingHours;
	}

}
