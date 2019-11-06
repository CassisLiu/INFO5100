package Assignment06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userData {
	private User user;
	private String password;
	private int accountBalance;
	private List<Transaction> transactions;
	public userData(User user, String password) {
		this.user = user;
		this.password = password;
		accountBalance = 0;
		transactions = new ArrayList<>();
	}

	public void resetPassword(String name, String age, String phone) {
		if(phone.equals(user.getPhone()) && age.equals(user.getAge()) 
				&& name.equalsIgnoreCase(user.getName())) {
			setPassword();
		}
	}	
	// public should be authorized to set pwd, unless you have been authenticated 
	private void setPassword() {			
		System.out.println("Please enter new password:");
		Scanner scanner = new Scanner(System.in);
		String pwd = scanner.nextLine();
		scanner.close();
		this.password = pwd;
		System.out.println("Reset password successfully.");
	}
	
	public void addTransaction(Transaction t) {
		transactions.add(t);
	}
	public User getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBlance(int newBalance) {
		accountBalance = newBalance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
}
