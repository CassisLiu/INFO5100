package VendingMachine;

import java.util.List;

public class Mahine {
	String machineID;
	String brand;
	List<Product> products;
	double sum = 0;
	
	public void acceptMoney(Money money) {
		switch(money) {
		case FiveCents :
			sum += 0.05;
			break;
		case TenCents :
			sum += 0.10;
			break;
		case Quarter :
			sum += 0.25;
			break;
		case FiftyCents :
			sum += 0.50;
			break;
		case OneDollar:
			sum += 1;
			break;
		case TenDollar :
			sum += 10;
			break;
		case TwentyDollar :	
			sum+= 20;
			break;
		}
	}
	
	public Product vendOut(Product product) {
		if(sum >= product.price) {
			return product;
		}		
		else return null;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
