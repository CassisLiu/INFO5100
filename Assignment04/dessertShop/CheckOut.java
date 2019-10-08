package Assignment04.dessertShop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CheckOut {
	List<DessertItem> itemList;
	int sum = 0;
	int tax = 0;
	
	public CheckOut() {
		itemList = new ArrayList();
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t").append(DessertShop.name).append("\n");
		sb.append("\t").append("---------------------------").append("\n").append("\n");
		for(int i = 0; i < itemList.size(); i++) {
			DessertItem item = itemList.get(i);
			String name = item.getClass().getName();
			if(name.equals("Candy") ) {
				try {
					sb.append(item.getClass().getField("weighted")).append(" lbs.  @ ").
					append(item.getClass().getField("pricePerDozen")).append(" /lb.");
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(name.equals("Cookie")) {
				try {
					sb.append(item.getClass().getField("number")).append(" @ ").
					append(item.getClass().getField("pricePerPound")).append(" /dz.");
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sb.append(name).append("\t").append(DessertShop.cents2dollarsAndCentsMethod(item.getCost()))
			.append("\n");
		}
		sb.append("Tax").append("\t").append(DessertShop.cents2dollarsAndCentsMethod(tax)).append("\n");
		sb.append("Total Cost").append("\t").append(DessertShop.cents2dollarsAndCentsMethod(sum));
		return sb.toString();
	}
	
	public int numberOfItems() {
		return itemList.size();
	}
	
	public void enterItem(DessertItem item) {
		itemList.add(item);
		sum += item.getCost();
	}
	
	public void clear() {
		itemList.clear();
		sum = 0;
		tax = 0;
	}
	
	public int totalCost() {
		return sum;
	}
	
	public int totalTax() {
		BigDecimal bd = new BigDecimal(sum * DessertShop.tax_rate).setScale(0, RoundingMode.HALF_EVEN);
		tax = bd.intValue();
		return tax;
	}
}
