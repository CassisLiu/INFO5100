package Assignment04.dessertShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cookie extends DessertItem{
	int number;
	int pricePerDozen;
	
	public Cookie(String name, int number, int price) {
		super(name);
		this.number = number;
		pricePerDozen = price;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		BigDecimal bd = new BigDecimal((double)(number)/12 * pricePerDozen).setScale(0, RoundingMode.HALF_EVEN);
		return bd.intValue();
	}
}
