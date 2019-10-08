package Assignment04.dessertShop;

public class DessertShop {
	static double tax_rate = 0.065;
	final static String name = "M & M Dessert Shop";
	int max_items;
	double width;
	
	public static String cents2dollarsAndCentsMethod(int cents) {
		double dollar = cents * 0.01;
		return String.valueOf(dollar);
	}
}
