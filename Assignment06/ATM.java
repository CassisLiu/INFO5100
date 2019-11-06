package Assignment06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ATM extends Machine {
	private int availableAmountInMachine;
	private int transactionFee;
	private final int accountNumberStarting = 10000;
	// Map<accountNumber, userData>
	Map<String, userData> users;
	
	public ATM(int availableAmountInMachine, int transactionFee) {
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		users = new HashMap<>();
	}
	@Override
	public void isNewUser() {
		System.out.println("Are you a new user? - 'Y' or 'N'");
		Scanner scan = new Scanner(System.in);
		String isNew = scan.next();
		scan.close();
		if(isNew.equalsIgnoreCase("Y")) {
			createUser();
		} else {
			Scanner scanner = new Scanner(System.in);
			String accountNumber = scanner.nextLine();
			String pwd = scanner.nextLine();
			scanner.close();
			login(accountNumber, pwd);
		}
	}
	
	/**
	 * User will enter 5 Strings 
	 * Including name, age, address, phone number and password
	 */
	@Override
	public void createUser() {
		System.out.println("Please enter your name, age, address, phone number and password (in different line).");
		Scanner scanner = new Scanner(System.in);
		String[] info = new String[5];
		for(int i = 0; i < 5; i++) {
			info[i] = scanner.nextLine();
		}
		String bankAccount = String.valueOf(accountNumberStarting + users.size());
		scanner.close();
		User user = new User(info[0],info[1],info[2],info[3],bankAccount);
		userData ud = new userData(user, info[4]);
		users.put(bankAccount, ud);
		System.out.println("New user create successfully!");
	}
	
	/**
	 * Use account number and password to authenticate user
	 * After logging in successfully, user can choose actions
	 * If log fails, the message will pop up
	 */
	@Override
	public void login(String accountNumber, String pwd) {
		// check authentication
		if(!users.containsKey(accountNumber)) {
			System.out.println("User doesn't exist.");
			return ;
		}
		
		// if not,remind user the account number / password is wrong
		userData ud = users.get(accountNumber);
		if(!ud.getPassword().equals(pwd)) {
			System.out.println("The password is wrong.");
		} else {
		// if successfully logged in, choose action
			System.out.println("Successfully logged in!");
			chooseAction(ud);
		}
	}
	
	/**
	 * After logging in successfully, user is asked to choose an action
	 * @param ud
	 */
	private void chooseAction(userData ud) {
		System.out.println("Choose your action:" + "\n" + "1. Check bank balance" + "\n"
				+ "2. WithDraw" +"\n" + "3. Deposit" + "\n" + "4. See recent transactions" + "\n"
				+ "5. Change your password" + "\n" + "6. Exit");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		scanner.close();
		switch(choice) {
		case "1": 
			System.out.println(availableBalance(ud));
			break;
		case "2":			
			withdrawal(ud);
			break;
		case "3":
			deposit(ud);
			break;
		case "4":
			showRecentTransaction(ud);
			break;
		case "5":
			resetPassword(ud);
			break;
		case "6":
			exit();
			break;
		}
	}

	@Override
	public void resetPassword(userData ud) {
		System.out.println("Please enter your name, age, and phone number to reset password:");
		// Input name, age, phone to validate user
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String age = scanner.nextLine();
		String phone = scanner.nextLine();
		scanner.close();
		// Use method from userData to reset password
		ud.resetPassword(name, age, phone);
	}
	
	
	/**
	 * @param userData
	 * @return user balance
	 */
	@Override
	public int availableBalance(userData ud) {
		// TODO Auto-generated method stub
		return ud.getAccountBalance();
	}
	
	
	/**
	 * Helper function for deposit and withdraw to request change amount from user
	 * @return change amount
	 */
	private int askForAmount() {
		System.out.println("Please enter the amount you want to change");
		Scanner sc = new Scanner(System.in);
		int change = sc.nextInt();
		sc.close();
		return change;
	}
	
	
	/**
	 * @param userData
	 * Change the amountBalancee in userData, and add this transaction to this user
	 */
	@Override
	public void withdrawal(userData ud) {
		int draw = askForAmount();
		if(isTransactionLegitimate(ud.getAccountBalance(), draw)) {
			Transaction t = new Transaction(Transaction.withdrawal, draw);
			ud.addTransaction(t);	
			availableAmountInMachine -= draw + addTransanctionFee();
		} else {
			System.out.println("The transaction is not valid.");
		}
	}
	private boolean isTransactionLegitimate(int balance, int draw) {
		if(draw + transactionFee <= balance && draw <= availableAmountInMachine) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param userData
	 * Change the amountBalancee in userData, and add this transaction to this user
	 */
	@Override
	public void deposit(userData ud) {
		int add = askForAmount();
		ud.setAccountBlance(ud.getAccountBalance() + add - transactionFee);
		Transaction t = new Transaction(Transaction.deposit, add);
		ud.addTransaction(t);
		availableAmountInMachine += add + addTransanctionFee();
	}
	
	/**
	 * Show recent ten transactions
	 * @param userData
	 */
	@Override
	public void showRecentTransaction(userData ud) {
		List<Transaction> trans = ud.getTransactions();
		for(int i = trans.size()-1; i >= Math.max(0, trans.size()-10); i--) {
			Transaction t = trans.get(i);
			System.out.println("The transaction type is: " + t.getTransaction() + 
					", and the amount is: " + t.getTransactionAmount());
		}
	}
	@Override
	public int addTransanctionFee() {
		return transactionFee;	
	}
	
	private void exit() {
		// TODO Auto-generated method stub		
	}
}
