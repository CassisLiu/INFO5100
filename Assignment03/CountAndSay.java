package Assignment03;
/*
 * 1.  1
2.     11
3.     21
4.     1211
5.     111221
 */
public class CountAndSay {
	public String countAndSay(int n) {
		String prev = "1";
		for(int i = 1; i <n ; i++) {
			StringBuilder sb  = new StringBuilder();
			char lastChar = ' ';
			int count = 0;
			for(int k = 0; k < prev.length(); k++) {
				if(prev.charAt(k) == lastChar) count++;
				else {
					if(count != 0) {
						sb.append(count).append(lastChar);
					}
					count = 1;
					lastChar = prev.charAt(k);
				}
			}
			sb.append(count).append(lastChar);
			prev = sb.toString();			
		}
		return prev;
	}
}
