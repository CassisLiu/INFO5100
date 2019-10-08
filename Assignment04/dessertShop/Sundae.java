package Assignment04.dessertShop;

public class Sundae extends IceCream{
	String toppings;
	int topping_price;
	
	public Sundae(String name, int pri, String toppings, int topping_price) {
		super(name, pri);
		this.toppings = toppings;
		this.topping_price = topping_price;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return priceInCents + topping_price;
	}

}
