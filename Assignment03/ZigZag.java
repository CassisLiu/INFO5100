package Assignment03;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {

	
	// direction of column only has one direction: +1
	public static String convert(String s, int numRows) {
		int[] dr = new int[] {1,-1};
		List<String> list = new ArrayList<>();
		for(int i =0 ; i < numRows; i++) {
			list.add("");
		}
		int di = 0, row = 0;
		for(int i = 0; i < s.length(); i++) {
			list.set(row, list.get(row) + s.charAt(i));
			int cr = row + dr[di];
			if(cr < numRows && cr >= 0) row = cr;
			else {
				di = (di + 1) % 2;
				row += dr[di];
			}
		}
		String result = "";
		for(int i = 0; i < numRows; i++) {
			result = result + list.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s,3));
	}

}
