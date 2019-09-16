
public class Admin {
	String admin_id;
	String adminName;
	long adminCode;
	CarRentalSystem sys;
	
	
	public Admin(String admin_id, String adminName, long adminCode) {
		this.adminName = adminName;
		this.adminCode = adminCode;
		sys = new CarRentalSystem();
	}
	
	public boolean login(String admin_id, String adminName, long adminCode) {
		return sys.adminLogin(admin_id, adminName, adminCode);
	}
	
	public void addCar(Car car) {
		if(car != null) sys.carsAvailable.add(car);
	}
	
	public Order checkOrder(long order_num) {
		return sys.orders.get(order_num);
	}
	
}
