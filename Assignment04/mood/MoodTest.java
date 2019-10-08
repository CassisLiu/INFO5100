package Assignment04.mood;

public class MoodTest {

	public static void main(String[] args) {
		Psychiatrist psy = new Psychiatrist();
		Moody mood1 = new Happy();
		Moody mood2 = new Sad();
		psy.examine(mood1);
		psy.observe(mood1);
		psy.examine(mood2);
		psy.observe(mood2);
	}

}
