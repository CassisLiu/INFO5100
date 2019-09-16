import java.util.Date;

public class CreditCard {
	String cardNumber;
	String cardHolder;
	Date expiredDate;
	long balance;
	
	public CreditCard(String cardNumber, String cardHolder) {
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
	}
	
	public boolean isAvailable() {
		Date today = new Date();
		return today.before(expiredDate);
	}
	
	public void pay(long bill) {
		balance -= bill;
	}
}
