package Assignment04.dessertShop;

abstract class DessertItem {
	String name ;
	
	public DessertItem() {}
	public DessertItem(String name) {
		this.name = name;
	}
	
	public abstract int getCost();
	public String getName() {
		return name;
	}
}
