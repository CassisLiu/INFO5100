package Assignment05;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Cat extends Pet implements Boardable{
	private String hairLength;
	private GregorianCalendar boardingStart;
	private GregorianCalendar boardingEnd;
	public Cat(String name, String owner, String color, String hairLength) {
		super(name, owner, color);
		// TODO Auto-generated constructor stub
		this.hairLength = hairLength;
	}
	
	public String toString() {
		String s = super.toString();
		s += "\nHair: " + hairLength;
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
