package VendingMachine;

import java.util.List;

public class Custom {
	Mahine useWhichMachine;
	
	public void purchase(List<Money> money, Product product) {		
		for(Money m : money) {
			useWhichMachine.acceptMoney(m);
		}
		if(useWhichMachine.sum >= product.price) 
			useWhichMachine.vendOut(product);
	}
}
