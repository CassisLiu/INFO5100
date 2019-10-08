package Assignment04.dessertShop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Candy extends DessertItem{
	double weighted;
	int pricePerPound ;

	public Candy(String name, double wei, int price) {
		super(name);
		weighted = wei;
		pricePerPound = price;
	}
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		BigDecimal bd = new BigDecimal(weighted * pricePerPound).setScale(0, RoundingMode.HALF_EVEN);
		return bd.intValue();
	}

}
