import java.sql.Date;

public class Order {
	long orderNum;
	User user;
	Car car;
	Date start;
	Date end;
	
	public Order(User user, Car car, Date start, Date end) {
		this.user = user;
		this.car = car;
		this.start = start;
		this.end = end;	
	}

}
