package Assignment04.dessertShop;

public class IceCream extends DessertItem{
	int priceInCents;
	
	public IceCream(String name, int pri) {
		super(name);
		priceInCents = pri;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return priceInCents;
	}
	
}
