package Assignment04.mood;

public class Psychiatrist {
	
	public Psychiatrist() {}
	public void examine(Moody mood) {
		System.out.println("How are you feeling today?");
		mood.queryMood();
	}
	
	public void observe(Moody mood) {
		mood.expressFeelings();
		System.out.print("Observation: " + mood);
	}
	
	
}
