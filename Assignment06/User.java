package Assignment06;

public class User {
	private String name;
	private String age;
	private String address;
	private String phone;
	private String bankAccountNumber;
	public User(String name, String age, String address, String phone, String bankAccount) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.bankAccountNumber = bankAccount;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getBankAccount() {
		return bankAccountNumber;
	}
	
}
