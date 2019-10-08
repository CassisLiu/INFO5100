package Assignment04.mood;

public class Sad extends Moody{
	
	@Override
	protected String getMood() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

	@Override
	protected void expressFeelings() {
		// TODO Auto-generated method stub
		System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep'");
		
	}

	@Override
	public void queryMood() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "Subject cries a lot";
	}

}
