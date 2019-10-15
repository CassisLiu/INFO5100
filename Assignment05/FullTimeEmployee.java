package Assignment05;

public class FullTimeEmployee extends Employee {

	public FullTimeEmployee(String name, int paymentPerHour) {
		super(name, paymentPerHour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateSalary() {
		// TODO Auto-generated method stub
		return getPaymentPerHour() * 8;
	}

}
