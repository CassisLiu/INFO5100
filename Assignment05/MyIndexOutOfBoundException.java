package Assignment05;

class MyIndexOutOfBoundException extends IndexOutOfBoundsException {
	private int lowerBound;
	private int upperBound;
	private int index;
	
	public MyIndexOutOfBoundException() {
		lowerBound = 0;
		upperBound = 9;
	}
	
	public int get(int i) {
		if(i > upperBound || i < lowerBound) {
			throw new IndexOutOfBoundsException("Error message: " + toString(i));
		}
		else return i;
	}
	
	public String toString(int index) {
		String s = index + ", but Lower bound: " + lowerBound + ", Upper bound:" + upperBound;
		return s;
	}
}

class Test {
	public static void main(String[] args) {
		try {
			
		} catch(MyIndexOutOfBoundException e) {
			
		}
	}
}
