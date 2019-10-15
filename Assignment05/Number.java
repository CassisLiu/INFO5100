package Assignment05;

public class Number {
  public double count(int a, int b) {
	  double res = 0.0;
	  try {
		  res = (double)a / (double)b;
	  } catch(ArithmeticException e) {
		  e.printStackTrace();
	  }
	  return res;
  }
}
