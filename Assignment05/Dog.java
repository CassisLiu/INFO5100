package Assignment05;

import java.util.GregorianCalendar;

public class Dog extends Pet implements Boardable{
	private String size;
	private GregorianCalendar boardingStart;
	private GregorianCalendar boardingEnd;
	public Dog(String name, String owner, String color, String size) {
		super(name, owner, color);
		// TODO Auto-generated constructor stub
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public String toString() {
		String s = super.toString();
		s += "\nSize: " + size;
		return s;
	}
	@Override
	public void setBoardStart(int month, int day, int year) {
		// TODO Auto-generated method stub		
		boardingStart = new GregorianCalendar(year, month, day);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		// TODO Auto-generated method stub
		boardingEnd = new GregorianCalendar(year, month, day);
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		if(date.after(boardingEnd) || date.before(boardingStart)) return false;
		return true;
	}
	
}
