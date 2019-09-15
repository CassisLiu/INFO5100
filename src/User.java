import java.sql.Date;
import java.util.List;

public class User {
	long userID; 
	String first_name;
	String last_name;
	String email;
	String pwd;
	CreditCard card;
	long order_num;
	CarRentalSystem sys;
	
	
	public User(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}
	
	public User(String first_name, String last_name, String email, String pwd) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.pwd = pwd;
		sys = new CarRentalSystem();
	}
	
	public boolean signUp(String first_name, String last_name, String email, String pwd) {
		return sys.signUp(first_name, last_name, email, pwd);
	}
	
	public boolean login(String email, String pwd) {
		return sys.login(email, pwd);
	}
	
	public List<Car> searchCars(Date start, Date end, Location pick_up_loc, int num_passengers) {	
		return sys.search(start, end, pick_up_loc, num_passengers);
	}
	
	public void bookACar(Car car, Date start_time, Date end_time) {
		order_num = sys.bookACar(car, this, start_time, end_time);
	}
	
	public void pay(Car car, Date start_time, Date end_time) {
		long payment = ( end_time.getDay() - start_time.getDay() ) * car.pricePerday;
		card.pay(payment);
	}

	public void cancel(long order_num) {
		sys.cancellation(order_num);
	}
}
