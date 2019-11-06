package Assignment06;

public class Transaction {
	public static final String withdrawal = "WithDrawal";
	public static final String deposit = "Deposit";
	private String transaction;
	private int transactionAmount;
	public Transaction(String transaction, int transactionAmount) {
		this.transaction = transaction;
		this.transactionAmount = transactionAmount;
	}
	public String getTransaction() {
		return transaction;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}	
	
}
