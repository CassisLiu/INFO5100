# INFO5100
Assignment for INFO5100 

Class: Car Rental System
 State:
  1) rental_system_name
  2) Admins 
  3）Users
  4）List of carsAvailable
  5）List of carsWaitingPickUp
  6）List of orders

 Actions:
	1) user sign-up 
  2) user login
  3) admin login
	4) search available cars 
		input: start_date, end_date, pick_up_location, number_of_passengers
		search from the available car list, add all the cars matching requirements to the matching car list
    return: list of cars matching search requirements
	3) rent car
		input: carToRent, userInfo, start_date, end_date 
		create the new order and add order to orderList
		remove car from available car list
		add car into waiting-to-pick-up car list
		return: order_number
	4）pick up a car
		input: user, order_num
		check whether the order number and the user info is correct
		remove car from waiting-to-pick-up car list
		no return
	5）return a car
    input: user, returnDate, order_num
		check whether it is returned on time
		if not, there is extra bill to pay
	6）cancellation  
    input: order_number


Admin
 State:
  1）id
  2）adminName
  3）adminCode
  4）carRentalSystemBelonged

 Actions: 
	1）login
	2）add a car
	3）check orders


User
 State:
  1）id 
  2）first_name
  3）last_name 
  4）email
  5）password
  6）card
  7）order_number
  8）system_logged_in
	
 Actions:
	1) sign up
  2）search available car 
	3) book a car
	4) pay the bill
	5) get the car on rent
	6) return car
	7) cancel an order


Car
 State:
  1）rent_price
  2）num_of_passengers
  3）location_zip
  4）availableFrom
  5）availableUntil


Order 
 State:
  1）order_number
  2）user
  3）car
  4）start_date
  5）end_date


CreditCard
 State:
  1）cardNumber
  2）carHolder
  3）expiredDate
  4）balance
  
Location
 State:
  1）street
  2）city
  3）state
  4）zipCode
  5）longitude
  6）latitude
