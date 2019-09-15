package TrafficLightControlSystem;


public enum Light {
    	S2N("N2S","S2W",false),S2W("N2E","E2W",false),E2W("W2E","E2S",false),E2S("","",false), 
    	N2S(null, null, false), N2E(null, null, false),W2E(null, null, false),W2N(null, null, false), 
    	S2E(null, null, true),E2N(null, null, true),N2W(null, null, true),W2S(null, null, true);
    	
    	String opposite;
    	String leftside;
    	boolean islighted;
    	
    	private Light(String opposite, String leftside, boolean islighted) {
    		this.opposite = opposite;
    		this.leftside = leftside;
    		this.islighted  = islighted;
    	}
    	
    	public boolean islighted() {
    		return islighted;
    	}
    	
    	
    	public void light() {
    		/* Turn the light into green -> islighted = true
    		 * Turn the opposite light into green
    		 */
    	}
    	
    	public Light blackOut() {
    		/* Turn the green light into red light -> islighted = false
    		 * Turn the opposite light into red light as well
    		 */

    		return Light.valueOf(leftside);
    	}
}

