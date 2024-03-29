package Assignment05;

abstract class Employee {
	private String Name;
	private int paymentPerHour;
	public Employee(String name, int paymentPerHour) {
		Name = name;
		this.paymentPerHour = paymentPerHour;
	}
	
	public abstract int calculateSalary();
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}

	public int getPaymentPerHour() {
		return paymentPerHour;
	}

	public void setPaymentPerHour(int paymentPerHour) {
		this.paymentPerHour = paymentPerHour;
	}	
}
