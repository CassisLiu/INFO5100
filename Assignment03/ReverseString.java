package Assignment03;

// method 1: split by space, reverse word one by one, 
// and add words to a sentence by reversed order	time:On + On
// method 2: reverse the whole sentense -> then reverse each word

class ReverseString {
	public static String reverseString(String s) {
		s = reverse(s);
		String[] parts = s.split(" ");
		for(int i = 0; i < parts.length; i++) {
			parts[i] = reverse(parts[i]);
		}
		s = String.join(" ", parts);
		return s;
	}
	
	
	private static String reverse(String s) {
		char[] arr = s.toCharArray();
		int i = 0, j = arr.length - 1;
		while(i < j) {
			char tmp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = tmp;
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		String s = "The sky is blue and I WILL GO TO PARK";
		System.out.println(reverseString(s));
	}
}
