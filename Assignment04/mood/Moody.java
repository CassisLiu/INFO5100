package Assignment04.mood;

public abstract class Moody {
	
	
	protected abstract String getMood();
	protected abstract void expressFeelings();
	public void queryMood() {
		System.out.println("I feel " + this.getClass().getName().toLowerCase() + " today!");
	}
	
}
