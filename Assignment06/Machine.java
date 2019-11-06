package Assignment06;

import java.util.List;

abstract class Machine {
	 public abstract void isNewUser();
	 public abstract void createUser();
	 public abstract void login(String accountNumber, String pwd); 
	 public abstract void resetPassword(userData ud);
	 public abstract int availableBalance(userData ud);
	 public abstract void withdrawal(userData ud);
	 public abstract void deposit(userData ud);
	 public abstract void showRecentTransaction(userData ud);
	 public abstract int addTransanctionFee();
}
