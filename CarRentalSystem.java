import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarRentalSystem {
	String rental_system_name;
	Map<String, Admin> admins;
	Map<String, User> users;
	List<Car> carsAvailable;
	List<Car> carsWaitingPickUp;
	Map<Long, Order> orders; // key: order_num, value: order
	
	/* The are two login page, one for admin, one for user
	 * Admin can add an available car, manage orders, manage rent
	 * User can sign up, log in, search available cars, make an order, pick up the car, return a car, 
	 * 			and cancel an order
	 */
	public boolean signUp(String first_name, String last_name, String email, String pwd) {
		User user = new User(first_name, last_name, email, pwd);
		if(users.containsKey(email)) return false;
		users.put(email, user);
		return true;
	}
	
	public boolean login(String email, String pwd) {
		if(email == null || pwd == null) return false;
		User user = users.get(email);
		if(users != null) {
			return user.email.equals(email) && user.pwd.equals(pwd);
		}		
		return false;
	}
	
	
	
	public boolean adminLogin(String admin_id, String adminName, long adminCode) {
		if(admin_id == null || adminName == null) return false;
		Admin admin = admins.get(admin_id);
		if(admin == null) return false;
		return admin.adminName.equals(adminName) && admin.adminCode == adminCode;
	}
	
	/* Search available car by date, pick_up_location, and number of passengers */
	public List<Car> search(Date start, Date end, Location pick_up_loc, int num_passengers) {
		List<Car> matchingCars = new ArrayList<Car>();
		for(Car car : carsAvailable) {
			if(start.after(car.availableFrom) && end.before(car.availableUntil) 
					&& pick_up_loc.zipCode == car.locationZip && num_passengers == car.capacity) {
				matchingCars.add(car);
			}
		}
		return matchingCars;
	}
	
	/* The user pick the car he want to rent, return the total rent he should pay */
	public long bookACar(Car car, User user, Date start_time, Date end_time) {
		Order order = new Order(user, car, start_time, end_time);
		long order_num = (long) Math.random() * 1000000;
		user.pay(car, start_time, end_time);
		orders.put(order_num, order);
		carsAvailable.remove(car);
		carsWaitingPickUp.add(car);
		return order_num;
	}

	
	public void pickUp(User user, long order_num) {
		if(orders.containsKey(order_num)) {
			Order order = orders.get(order_num);
			if(user.equals(order.user)) {
				carsWaitingPickUp.remove(order.car);
			}
		}
	}
	
	public void returnCar(User user, Date returnDate, long order_num) {
		Order order = orders.get(order_num);
		int extraBill = 0;
		if(returnDate.after(order.end)) {
			extraBill = (returnDate.getDay() - order.end.getDay()) * order.car.pricePerday;
		}
		user.card.pay(extraBill);
	}
	
	public void cancellation(long order_num) {
		if(orders.containsKey(order_num)) orders.remove(order_num);
	}
		
}
